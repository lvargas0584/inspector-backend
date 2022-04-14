package org.inspector.security.provider.Impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.inspector.security.config.JwtConfiguration;
import org.inspector.security.provider.JwtProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class JwtProviderImpl implements JwtProvider {

    @Inject
    JwtConfiguration jwtConfiguration;

    @Override
    public String generateToken(Map<String, String> claims) {
        Claims _claims = Jwts.claims();

        for(Map.Entry<String, String> entry :  claims.entrySet()) {
            _claims.put(entry.getKey(), entry.getValue());
        }

        Key key = Keys.hmacShaKeyFor(jwtConfiguration.secretKey().getBytes());

        return Jwts.builder()
                .setClaims(_claims).signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfiguration.expirationTime()))
                .setIssuedAt(new Date())
                .setIssuer(jwtConfiguration.issuer())
                .setAudience(jwtConfiguration.audience()).compact();
    }

    @Override
    public Map<String, String> validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(jwtConfiguration.secretKey().getBytes());

            Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(resolve(token)).getBody();

            HashMap<String,String> map =  new HashMap();

            for(Map.Entry<String, Object> entry :  claims.entrySet()) {
                map.put(entry.getKey(), entry.getValue().toString());
            }

            return map;
        }
        catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

    public String resolve(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }

}