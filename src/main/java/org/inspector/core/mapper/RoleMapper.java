package org.inspector.core.mapper;

import org.inspector.core.dto.RoleDto;
import org.inspector.core.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface RoleMapper {
    @Mappings({
            @Mapping(target = "name", source = "roleName"),
            @Mapping(target = "code", source = "roleCode")
    })
    RoleDto toDto(Role role);

    @Mappings({
            @Mapping(target = "roleName", source = "name"),
            @Mapping(target = "roleCode", source = "code")
    })
    Role toEntity(RoleDto roleDto);
}