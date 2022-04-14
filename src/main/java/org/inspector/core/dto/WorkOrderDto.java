package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class WorkOrderDto {
    private ObjectId id;
    private String code;
    private String customer;
    private String location;
    private String inspector;
    private String inspectionType;
    private String usedSpecification;
    private String descriptionTool;
    private List<PipeDto> pipes;
    private List<String> assistants;
    private InspectionTypeFieldsDto fields;
}