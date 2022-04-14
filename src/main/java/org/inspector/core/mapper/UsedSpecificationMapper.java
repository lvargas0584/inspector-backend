package org.inspector.core.mapper;

import org.inspector.core.dto.UsedSpecificationDto;
import org.inspector.core.entity.UsedSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface UsedSpecificationMapper {
    @Mappings({
            @Mapping(target = "name", source = "specificationName"),
            @Mapping(target = "shortName", source = "specificationShort")
    })
    UsedSpecificationDto toDto(UsedSpecification inspectionType);

    @Mappings({
            @Mapping(target = "specificationName", source = "name"),
            @Mapping(target = "specificationShort", source = "shortName")
    })
    UsedSpecification toEntity(UsedSpecificationDto inspectionTypeDto);
}
