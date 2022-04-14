package org.inspector.core.mapper;

import org.inspector.core.dto.InspectionTypeDto;
import org.inspector.core.entity.InspectionType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi",  uses = { InspectionTypeFieldMapper.class })
public interface InspectionTypeMapper {
    @Mappings({
            @Mapping(target = "name", source = "inspectionName"),
            @Mapping(target = "shortName", source = "inspectionShort")
    })
    InspectionTypeDto toDto(InspectionType inspectionType);

    @Mappings({
            @Mapping(target = "inspectionName", source = "name"),
            @Mapping(target = "inspectionShort", source = "shortName")
    })
    InspectionType toEntity(InspectionTypeDto inspectionTypeDto);
}
