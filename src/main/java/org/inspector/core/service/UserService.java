package org.inspector.core.service;

import org.inspector.core.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUser(String userId);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, String userId);
}