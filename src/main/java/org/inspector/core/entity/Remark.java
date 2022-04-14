package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "remarks")
public class Remark extends PanacheMongoEntity implements Serializable {

    @BsonProperty("code")
    private String Code;

    @BsonProperty("text")
    private String Text;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}