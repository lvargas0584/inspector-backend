package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity implements Serializable {

    @BsonProperty("code")
    private String Code;

    @BsonProperty("name")
    private String Name;

    @BsonProperty("paternal_surname")
    private String PaternalSurname;

    @BsonProperty("maternal_surname")
    private String MaternalSurname;

    @BsonProperty("document")
    private String Document;

    @BsonProperty("email")
    private String Email;

    @BsonProperty("password")
    private String Password;

    @BsonProperty("role")
    private String Role;

    @BsonProperty("active")
    private Boolean Active;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPaternalSurname() {
        return PaternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        PaternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return MaternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        MaternalSurname = maternalSurname;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String Document) {
        this.Document = Document;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean Active) {
        this.Active = Active;
    }
}
