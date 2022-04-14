package org.inspector.core.mapper;

import org.inspector.core.dto.PipeDto;
import org.inspector.core.entity.Pipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = { PipeBodyMapper.class, PipeBoxMapper.class, PipePinMapper.class })
public interface PipeMapper {

    PipeDto toDto(Pipe pipe);

    Pipe toEntity(PipeDto pipeDto);
}