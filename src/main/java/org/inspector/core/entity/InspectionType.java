package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "inspection_types")
public class InspectionType extends PanacheMongoEntity implements Serializable {

    @BsonProperty("inspection_name")
    private String InspectionName;

    @BsonProperty("inspection_short")
    private String InspectionShort;

    @BsonProperty("inspection_fields")
    private InspectionTypeFields InspectionTypeFields;

    public String getInspectionName() {
        return InspectionName;
    }

    public void setInspectionName(String inspectionName) {
        InspectionName = inspectionName;
    }

    public String getInspectionShort() {
        return InspectionShort;
    }

    public void setInspectionShort(String inspectionShort) {
        InspectionShort = inspectionShort;
    }

    public InspectionTypeFields getInspectionTypeFields() {
        return InspectionTypeFields;
    }

    public void setInspectionTypeFields(InspectionTypeFields inspectionTypeFields) {
        InspectionTypeFields = inspectionTypeFields;
    }
}