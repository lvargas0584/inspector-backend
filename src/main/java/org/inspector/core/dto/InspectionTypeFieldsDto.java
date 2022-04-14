package org.inspector.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class InspectionTypeFieldsDto {
    private List<String> Pin;
    private List<String> Box;
    private List<String> Body;
}
