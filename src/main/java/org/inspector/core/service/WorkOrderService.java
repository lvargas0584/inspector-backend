package org.inspector.core.service;

import org.inspector.core.dto.PipeDto;
import org.inspector.core.dto.WorkOrderDto;
import org.inspector.core.entity.WorkOrder;

import java.util.List;

public interface WorkOrderService {
    List<WorkOrderDto> getWorkOrders(Boolean allScope);
    WorkOrderDto getWorkOrderById(String workOrderId);
    WorkOrderDto saveWorkOrder(WorkOrderDto workOrderDto);
    WorkOrderDto updateWorkOrder(String workOrderId, WorkOrderDto workOrderDto);

    WorkOrderDto updatePipeByWorkOrder(String workOrderId, String pipeId, PipeDto pipeDto);
}
