package org.inspector.core.service.impl;

import org.bson.types.ObjectId;
import org.inspector.core.dto.DescriptionToolDto;
import org.inspector.core.dto.InspectionTypeDto;
import org.inspector.core.dto.RemarkDto;
import org.inspector.core.dto.UsedSpecificationDto;
import org.inspector.core.entity.DescriptionTool;
import org.inspector.core.entity.InspectionType;
import org.inspector.core.entity.Remark;
import org.inspector.core.entity.UsedSpecification;
import org.inspector.core.mapper.*;
import org.inspector.core.service.SettingsService;
import org.inspector.core.util.Util;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class SettingsServiceImpl implements SettingsService {

    @Inject
    InspectionTypeMapper inspectionTypeMapper;

    @Inject
    InspectionTypeFieldMapper inspectionTypeFieldMapper;

    @Inject
    UsedSpecificationMapper usedSpecificationMapper;

    @Inject
    DescriptionToolMapper descriptionToolMapper;

    @Inject
    RemarkMapper remarkMapper;

    @Override
    public List<InspectionTypeDto> getInspectionTypes() {
        return InspectionType.findAll().stream()
                .map(e -> inspectionTypeMapper.toDto((InspectionType) e))
                .collect(Collectors.toList());
    }

    @Override
    public InspectionTypeDto getInspectionTypeById(String inspectionTypeId) {
        return InspectionType.findByIdOptional(new ObjectId(inspectionTypeId))
                .map(e -> inspectionTypeMapper.toDto((InspectionType) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public InspectionTypeDto updateInspectionType(String inspectionTypeId, InspectionTypeDto inspectionTypeDto) {
        InspectionType inspectionType = (InspectionType) InspectionType.findByIdOptional(new ObjectId(inspectionTypeId))
                .orElseThrow(NotFoundException::new);

        if (!Util.isNullOrEmpty(inspectionTypeDto.getName())) {
            inspectionType.setInspectionName(inspectionTypeDto.getName());
        }
        if (inspectionTypeDto.getInspectionTypeFields() != null) {
            inspectionType.setInspectionTypeFields(
                    inspectionTypeFieldMapper.toEntity(inspectionTypeDto.getInspectionTypeFields())
            );
        }

        inspectionType.persistOrUpdate();

        return inspectionTypeMapper.toDto(inspectionType);
    }

    @Override
    public InspectionTypeDto saveInspectionType(InspectionTypeDto inspectionTypeDto) {
        InspectionType inspectionType = inspectionTypeMapper.toEntity(inspectionTypeDto);
        inspectionType.persistOrUpdate();
        return inspectionTypeMapper.toDto(inspectionType);
    }

    @Override
    public List<UsedSpecificationDto> getUsedSpecifications() {
        return UsedSpecification.findAll().stream()
                .map(e -> usedSpecificationMapper.toDto((UsedSpecification) e))
                .collect(Collectors.toList());
    }

    @Override
    public UsedSpecificationDto getUsedSpecificationById(String usedSpecificationId) {
        return UsedSpecification.findByIdOptional(new ObjectId(usedSpecificationId))
                .map(e -> usedSpecificationMapper.toDto((UsedSpecification) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public UsedSpecificationDto saveUsedSpecification(UsedSpecificationDto usedSpecificationDto) {
        UsedSpecification usedSpecification = usedSpecificationMapper.toEntity(usedSpecificationDto);
        usedSpecification.persistOrUpdate();
        return usedSpecificationMapper.toDto(usedSpecification);
    }

    @Override
    public UsedSpecificationDto updateUsedSpecification(String usedSpecificationId, UsedSpecificationDto usedSpecificationDto) {
        UsedSpecification usedSpecification = (UsedSpecification) UsedSpecification.findByIdOptional(new ObjectId(usedSpecificationId))
                .orElseThrow(NotFoundException::new);

        if (!Util.isNullOrEmpty(usedSpecificationDto.getName())) {
            usedSpecification.setSpecificationName(usedSpecificationDto.getName());
        }

        if (!Util.isNullOrEmpty(usedSpecificationDto.getShortName())) {
            usedSpecification.setSpecificationShort(usedSpecificationDto.getShortName());
        }

        usedSpecification.persistOrUpdate();

        return usedSpecificationMapper.toDto(usedSpecification);
    }

    @Override
    public List<DescriptionToolDto> getDescriptionTools() {
        return DescriptionTool.findAll().stream()
                .map(e -> descriptionToolMapper.toDto((DescriptionTool) e))
                .collect(Collectors.toList());
    }

    @Override
    public DescriptionToolDto getDescriptionToolById(String descriptionToolId) {
        return DescriptionTool.findByIdOptional(new ObjectId(descriptionToolId))
                .map(e -> descriptionToolMapper.toDto((DescriptionTool) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public DescriptionToolDto saveDescriptionTool(DescriptionToolDto descriptionToolDto) {
        DescriptionTool descriptionTool = descriptionToolMapper.toEntity(descriptionToolDto);
        descriptionTool.persistOrUpdate();
        return descriptionToolMapper.toDto(descriptionTool);
    }

    @Override
    public DescriptionToolDto updateDescriptionTool(String descriptionToolId, DescriptionToolDto descriptionToolDto) {
        DescriptionTool descriptionTool = (DescriptionTool) DescriptionTool.findByIdOptional(new ObjectId(descriptionToolId))
                .orElseThrow(NotFoundException::new);

        if (!Util.isNullOrEmpty(descriptionToolDto.getName())) {
            descriptionTool.setDescriptionName(descriptionToolDto.getName());
        }

        if (!Util.isNullOrEmpty(descriptionToolDto.getShortName())) {
            descriptionTool.setDescriptionShort(descriptionToolDto.getShortName());
        }

        descriptionTool.persistOrUpdate();

        return descriptionToolMapper.toDto(descriptionTool);
    }

    @Override
    public List<RemarkDto> getRemarks() {
        return Remark.findAll().stream()
                .map(e -> remarkMapper.toDto((Remark) e))
                .collect(Collectors.toList());
    }

    @Override
    public RemarkDto saveRemark(RemarkDto remarkDto) {
        Remark remark = remarkMapper.toEntity(remarkDto);
        remark.persistOrUpdate();
        return remarkMapper.toDto(remark);
    }
}