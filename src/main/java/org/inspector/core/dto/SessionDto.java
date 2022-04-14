package org.inspector.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionDto {
    private String token;
    private UserDto user;
}