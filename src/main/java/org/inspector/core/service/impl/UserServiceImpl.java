package org.inspector.core.service.impl;

import org.bson.types.ObjectId;
import org.inspector.core.dto.UserDto;
import org.inspector.core.entity.User;
import org.inspector.core.mapper.UserMapper;
import org.inspector.core.service.UserService;
import org.inspector.core.util.Util;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return User.findAll().stream()
                .map(e -> userMapper.toDto((User) e))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(String userId) {
        return User.findByIdOptional(new ObjectId(userId))
                .map(e -> userMapper.toDto((User) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setActive(true);
        user.setPassword(Util.generateHashMD5(userDto.getPassword()));
        user.persistOrUpdate();
        return  userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = (User) User.findByIdOptional(new ObjectId(userId))
                .orElseThrow(NotFoundException::new);

        if  (!Util.isNullOrEmpty(userDto.getRole())) {
            user.setRole(userDto.getRole());
        }
        if  (!Util.isNullOrEmpty(userDto.getName())) {
            user.setName(userDto.getName());
        }
        if(!Util.isNullOrEmpty(userDto.getPaternalSurname())) {
            user.setPaternalSurname(userDto.getPaternalSurname());
        }
        if(!Util.isNullOrEmpty(userDto.getMaternalSurname())) {
            user.setMaternalSurname(userDto.getMaternalSurname());
        }
        if(!Util.isNullOrEmpty(userDto.getPassword())) {
            user.setPassword(Util.generateHashMD5(userDto.getPassword()));
        }

        user.persistOrUpdate();
        return userMapper.toDto(user);
    }
}
