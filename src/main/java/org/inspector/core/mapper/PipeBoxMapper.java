package org.inspector.core.mapper;

import org.inspector.core.dto.PipeBoxDto;
import org.inspector.core.entity.PipeBox;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PipeBoxMapper {
    PipeBoxDto toDto(PipeBox pipeBox);
    PipeBox toEntity(PipeBoxDto pipeBoxDto);
}
