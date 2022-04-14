package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "roles")
public class Role extends PanacheMongoEntity implements Serializable {

    @BsonProperty("role_code")
    private String RoleCode;

    @BsonProperty("role_name")
    private String RoleName;

    public Role() { }

    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String roleCode) {
        RoleCode = roleCode;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
}