package org.inspector.core.mapper;

import org.inspector.core.dto.InspectionTypeFieldsDto;
import org.inspector.core.entity.InspectionTypeFields;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface InspectionTypeFieldMapper {
    InspectionTypeFieldsDto toDto(InspectionTypeFields inspectionType);
    InspectionTypeFields toEntity(InspectionTypeFieldsDto inspectionTypeDto);
}