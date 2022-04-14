package org.inspector.core.service;

import org.inspector.core.dto.DescriptionToolDto;
import org.inspector.core.dto.InspectionTypeDto;
import org.inspector.core.dto.RemarkDto;
import org.inspector.core.dto.UsedSpecificationDto;

import java.util.List;

public interface SettingsService {
    List<InspectionTypeDto> getInspectionTypes();
    InspectionTypeDto getInspectionTypeById(String inspectionTypeId);
    InspectionTypeDto updateInspectionType(String inspectionTypeId, InspectionTypeDto inspectionTypeDto);
    InspectionTypeDto saveInspectionType(InspectionTypeDto inspectionTypeDto);

    List<UsedSpecificationDto> getUsedSpecifications();
    UsedSpecificationDto getUsedSpecificationById(String usedSpecificationId);
    UsedSpecificationDto saveUsedSpecification(UsedSpecificationDto usedSpecificationDto);
    UsedSpecificationDto updateUsedSpecification(String usedSpecificationId, UsedSpecificationDto usedSpecificationDto);

    List<DescriptionToolDto> getDescriptionTools();
    DescriptionToolDto getDescriptionToolById(String descriptionToolId);
    DescriptionToolDto saveDescriptionTool(DescriptionToolDto descriptionToolDto);
    DescriptionToolDto updateDescriptionTool(String descriptionToolId, DescriptionToolDto descriptionToolDto);

    List<RemarkDto> getRemarks();
    RemarkDto saveRemark(RemarkDto remarkDto);
}