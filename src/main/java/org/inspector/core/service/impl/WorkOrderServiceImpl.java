package org.inspector.core.service.impl;

import org.bson.types.ObjectId;
import org.inspector.core.dto.PipeDto;
import org.inspector.core.dto.PipePinDto;
import org.inspector.core.dto.WorkOrderDto;
import org.inspector.core.entity.*;
import org.inspector.core.mapper.*;
import org.inspector.core.service.WorkOrderService;
import org.inspector.core.util.Util;
import org.inspector.security.session.UserSession;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class WorkOrderServiceImpl implements WorkOrderService {

    @Inject
    UserSession userSession;

    @Inject
    WorkOrderMapper workOrderMapper;

    @Inject
    PipeMapper pipeMapper;

    @Inject
    PipePinMapper pipePinMapper;

    @Inject
    PipeBoxMapper pipeBoxMapper;

    @Inject
    PipeBodyMapper pipeBodyMapper;

    @Inject
    InspectionTypeFieldMapper inspectionTypeFieldMapper;

    @Override
    public List<WorkOrderDto> getWorkOrders(Boolean allScope) {
        if (allScope != null && allScope) {
            return WorkOrder.findAll().stream()
                    .map(e -> workOrderMapper.toDto((WorkOrder) e))
                    .collect(Collectors.toList());
        }
        String userId = userSession.getPayload().get("userId");
        return WorkOrder.find("{ $or: [ { 'inspector': ?1 }, { 'assistants': ?2 } ] }", userId, userId).stream()
                .map(e -> workOrderMapper.toDto((WorkOrder) e))
                .collect(Collectors.toList());
    }

    @Override
    public WorkOrderDto getWorkOrderById(String workOrderId) {
        return WorkOrder.findByIdOptional(new ObjectId(workOrderId))
                .map(e -> workOrderMapper.toDto((WorkOrder) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public WorkOrderDto saveWorkOrder(WorkOrderDto workOrderDto) {
        WorkOrder workOrder = workOrderMapper.toEntity(workOrderDto);
        workOrder.setPipes(
                workOrder.getPipes().stream().peek(s-> s.setId(Util.generateUUID())).collect(Collectors.toList())
        );
        workOrder.persistOrUpdate();
        return  workOrderMapper.toDto(workOrder);
    }

    @Override
    public WorkOrderDto updateWorkOrder(String workOrderId, WorkOrderDto workOrderDto) {
        WorkOrder workOrder  = (WorkOrder) WorkOrder.findByIdOptional(new ObjectId(workOrderId))
                .orElseThrow(NotFoundException::new);
        workOrder.setAssistants(workOrderDto.getAssistants());
        workOrder.setPipes(
                workOrderDto.getPipes().stream().map(pipe -> {
                    if (Util.isNullOrEmpty(pipe.getId())) {
                        pipe.setId(Util.generateUUID());
                    }
                    return pipeMapper.toEntity(pipe);
                }).collect(Collectors.toList())
        );
        workOrder.setCustomer(workOrderDto.getCustomer());
        workOrder.setDescriptionTool(workOrderDto.getDescriptionTool());
        workOrder.setFields(inspectionTypeFieldMapper.toEntity(workOrderDto.getFields()));
        workOrder.setInspectionType(workOrderDto.getInspectionType());
        workOrder.setInspector(workOrderDto.getInspector());
        workOrder.setLocation(workOrderDto.getLocation());
        workOrder.setUsedSpecification(workOrderDto.getUsedSpecification());

        workOrder.persistOrUpdate();

        return workOrderMapper.toDto(workOrder);
    }

    @Override
    public WorkOrderDto updatePipeByWorkOrder(String workOrderId, String pipeId, PipeDto pipeDto) {
        WorkOrder workOrder = (WorkOrder) WorkOrder.findByIdOptional(new ObjectId(workOrderId))
                .orElseThrow(NotFoundException::new);

        workOrder.setPipes(
                workOrder.getPipes().stream().peek(pipe -> {
                    if (pipe.getId().equals(pipeId)) {
                        if (!Util.isNullOrEmpty(pipeDto.getSerialCode())) {
                            pipe.setSerialCode(pipeDto.getSerialCode());
                        }
                        if (pipeDto.getPipePin() != null) {
                            pipe.setPipePin(pipePinMapper.toEntity(pipeDto.getPipePin()));
                        }
                        if (pipeDto.getPipeBox() != null) {
                            pipe.setPipeBox(pipeBoxMapper.toEntity(pipeDto.getPipeBox()));
                        }
                        if (pipeDto.getPipeBody() != null) {
                            pipe.setPipeBody(pipeBodyMapper.toEntity(pipeDto.getPipeBody()));
                        }
                    }
                }).collect(Collectors.toList())
        );

        workOrder.persistOrUpdate();

        return workOrderMapper.toDto(workOrder);
    }

    private PipePin assignPipePin(PipePin pipePin, PipePinDto pipePinDto) {
        if (pipePinDto.getPinOutside() != null) {
          pipePin.setPinOutside(pipePinDto.getPinOutside());
        }
        if (pipePinDto.getPinInside() != null) {
            pipePin.setPinInside(pipePinDto.getPinInside());
        }
        if (pipePinDto.getPinBevel() != null) {
            pipePin.setPinBevel(pipePinDto.getPinBevel());
        }
        if (pipePinDto.getPinNeck() != null) {
            pipePin.setPinNeck(pipePinDto.getPinNeck());
        }
        if (pipePinDto.getPinLpc() != null) {
            pipePin.setPinLpc(pipePinDto.getPinLpc());
        }
        if (pipePinDto.getPinTong() != null) {
            pipePin.setPinTong(pipePinDto.getPinTong());
        }
        if (pipePinDto.getPinHardBandHt() != null) {
            pipePin.setPinHardBandHt(pipePinDto.getPinHardBandHt());
        }
        if (pipePinDto.getPinHardBandApply() != null) {
            pipePin.setPinHardBandApply(pipePinDto.getPinHardBandApply());
        }
        if (pipePinDto.getPinVt() != null) {
            pipePin.setPinVt(pipePinDto.getPinVt());
        }
        if (pipePinDto.getPinFinalCond() != null) {
            pipePin.setPinFinalCond(pipePinDto.getPinFinalCond());
        }

        return pipePin;
    }
}
