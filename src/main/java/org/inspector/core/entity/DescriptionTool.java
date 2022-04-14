package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "description_tools")
public class DescriptionTool extends PanacheMongoEntity implements Serializable {

    @BsonProperty("description_name")
    private String DescriptionName;

    @BsonProperty("description_short")
    private String DescriptionShort;

    public String getDescriptionName() {
        return DescriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        DescriptionName = descriptionName;
    }

    public String getDescriptionShort() {
        return DescriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        DescriptionShort = descriptionShort;
    }
}