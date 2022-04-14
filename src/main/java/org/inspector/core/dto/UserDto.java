package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class UserDto {
    private ObjectId id;
    private String code;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String document;
    private String email;
    private String password;
    private String role;
    private Boolean active;
}