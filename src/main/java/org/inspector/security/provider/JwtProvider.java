package org.inspector.security.provider;

import java.util.Map;

public interface JwtProvider {
    String generateToken(Map<String,String> claims);
    Map<String,String> validateToken(String token);
}
