package org.inspector.core.service.impl;

import org.bson.types.ObjectId;
import org.inspector.core.dto.RoleDto;
import org.inspector.core.entity.Role;
import org.inspector.core.mapper.RoleMapper;
import org.inspector.core.service.RoleService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class RoleServiceImpl implements RoleService {

    @Inject
    RoleMapper roleMapper;

    @Override
    public List<RoleDto> getRoles() {
        return Role.findAll().stream()
                .map(e -> roleMapper.toDto((Role) e))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto getRole(String roleId) {
        return Role.findByIdOptional(new ObjectId(roleId))
                .map(e -> roleMapper.toDto((Role) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        role.persistOrUpdate();
        return roleMapper.toDto(role);
    }
}
