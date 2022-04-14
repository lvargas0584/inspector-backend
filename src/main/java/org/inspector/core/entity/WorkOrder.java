package org.inspector.core.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.List;


@MongoEntity(collection = "work_orders")
public class WorkOrder extends PanacheMongoEntity implements Serializable {

    @BsonProperty("code")
    private String Code;

    @BsonProperty("customer")
    private String Customer;

    @BsonProperty("location")
    private String Location;

    @BsonProperty("inspector")
    private String Inspector;

    @BsonProperty("inspection_type")
    private String InspectionType;

    @BsonProperty("used_specification")
    private String UsedSpecification;

    @BsonProperty("description_tool")
    private String DescriptionTool;

    @BsonProperty("pipes")
    private List<Pipe> Pipes;

    @BsonProperty("assistants")
    private List<String> Assistants;

    @BsonProperty("fields")
    private InspectionTypeFields Fields;

    @BsonProperty("is_decimal")
    private Boolean isDecimal;

    public Boolean getDecimal() {
        return isDecimal;
    }

    public void setDecimal(Boolean decimal) {
        isDecimal = decimal;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getInspector() {
        return Inspector;
    }

    public void setInspector(String inspector) {
        Inspector = inspector;
    }

    public String getInspectionType() {
        return InspectionType;
    }

    public void setInspectionType(String inspectionType) {
        InspectionType = inspectionType;
    }

    public String getUsedSpecification() {
        return UsedSpecification;
    }

    public void setUsedSpecification(String usedSpecification) {
        UsedSpecification = usedSpecification;
    }

    public String getDescriptionTool() {
        return DescriptionTool;
    }

    public void setDescriptionTool(String descriptionTool) {
        DescriptionTool = descriptionTool;
    }

    public List<Pipe> getPipes() {
        return Pipes;
    }

    public void setPipes(List<Pipe> pipes) {
        Pipes = pipes;
    }

    public List<String> getAssistants() {
        return Assistants;
    }

    public void setAssistants(List<String> assistants) {
        Assistants = assistants;
    }

    public InspectionTypeFields getFields() {
        return Fields;
    }

    public void setFields(InspectionTypeFields fields) {
        this.Fields = fields;
    }
}