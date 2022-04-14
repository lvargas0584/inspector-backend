package org.inspector.core.mapper;

import org.inspector.core.dto.DescriptionToolDto;
import org.inspector.core.entity.DescriptionTool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface DescriptionToolMapper {
    @Mappings({
            @Mapping(target = "name", source = "descriptionName"),
            @Mapping(target = "shortName", source = "descriptionShort")
    })
    DescriptionToolDto toDto(DescriptionTool descriptionTool);

    @Mappings({
            @Mapping(target = "descriptionName", source = "name"),
            @Mapping(target = "descriptionShort", source = "shortName")
    })
    DescriptionTool toEntity(DescriptionToolDto descriptionToolDto);
}
