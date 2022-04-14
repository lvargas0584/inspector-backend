package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class RoleDto {
    private ObjectId id;
    private String code;
    private String name;
}