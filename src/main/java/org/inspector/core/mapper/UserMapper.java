package org.inspector.core.mapper;

import org.inspector.core.dto.UserDto;
import org.inspector.core.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}