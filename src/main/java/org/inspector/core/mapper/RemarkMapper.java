package org.inspector.core.mapper;

import org.inspector.core.dto.RemarkDto;
import org.inspector.core.entity.Remark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RemarkMapper {
    RemarkDto toDto(Remark role);
    Remark toEntity(RemarkDto roleDto);
}