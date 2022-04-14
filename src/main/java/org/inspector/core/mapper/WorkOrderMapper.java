package org.inspector.core.mapper;

import org.inspector.core.dto.WorkOrderDto;
import org.inspector.core.entity.WorkOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = { PipeMapper.class })
public interface WorkOrderMapper {
    WorkOrderDto toDto(WorkOrder workOrder);

    WorkOrder toEntity(WorkOrderDto workOrderDto);
}