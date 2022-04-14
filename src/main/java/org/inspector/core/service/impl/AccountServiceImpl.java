package org.inspector.core.service.impl;

import org.inspector.core.dto.LoginDto;
import org.inspector.core.dto.SessionDto;
import org.inspector.core.dto.UserDto;
import org.inspector.core.entity.User;
import org.inspector.core.mapper.UserMapper;
import org.inspector.core.service.AccountService;
import org.inspector.core.util.Util;
import org.inspector.security.provider.JwtProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountServiceImpl implements AccountService {

    @Inject
    UserMapper userMapper;

    @Inject
    JwtProvider _jwtProvider;

    @Override
    public SessionDto login(LoginDto loginDto) {
        User user = (User) User.find("email = ?1", loginDto.getEmail())
                .firstResultOptional()
                .orElseThrow(NotFoundException::new);

        if (!Util.compareHash(loginDto.getPassword(), user.getPassword())) {
            throw new NotFoundException();
        }

        UserDto userDto = userMapper.toDto(user);
        userDto.setPassword(null);

        return SessionDto.builder()
                .token(_jwtProvider.generateToken(buildClaims(userDto)))
                .user(userDto)
                .build();
    }

    private Map<String, String> buildClaims(UserDto userDto) {
        Map<String, String> claims = new HashMap<>();
        claims.put("userId", userDto.getId().toString());
        claims.put("code", userDto.getCode());
        claims.put("name", userDto.getName());
        return claims;
    }
}
