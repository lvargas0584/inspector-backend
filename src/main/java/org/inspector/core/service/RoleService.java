package org.inspector.core.service;

import org.inspector.core.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getRoles();
    RoleDto getRole(String roleId);
    RoleDto saveRole(RoleDto roleDto);
}
