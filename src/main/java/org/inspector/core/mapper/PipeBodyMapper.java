package org.inspector.core.mapper;

import org.inspector.core.dto.PipeBodyDto;
import org.inspector.core.entity.PipeBody;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PipeBodyMapper {

    PipeBodyDto toDto(PipeBody pipeBody);

    PipeBody toEntity(PipeBodyDto pipeBodyDto);
}
