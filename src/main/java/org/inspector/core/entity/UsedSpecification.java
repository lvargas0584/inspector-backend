package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "used_specifications")
public class UsedSpecification extends PanacheMongoEntity implements Serializable {

    @BsonProperty("specification_name")
    private String SpecificationName;

    @BsonProperty("specification_short")
    private String SpecificationShort;

    public String getSpecificationName() {
        return SpecificationName;
    }

    public void setSpecificationName(String specificationName) {
        SpecificationName = specificationName;
    }

    public String getSpecificationShort() {
        return SpecificationShort;
    }

    public void setSpecificationShort(String specificationShort) {
        SpecificationShort = specificationShort;
    }
}
