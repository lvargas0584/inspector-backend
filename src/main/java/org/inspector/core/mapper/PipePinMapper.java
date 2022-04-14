package org.inspector.core.mapper;

import org.inspector.core.dto.PipePinDto;
import org.inspector.core.entity.PipePin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PipePinMapper {
    PipePinDto toDto(PipePin pipePin);

    PipePin toEntity(PipePinDto pipePinDto);
}
