package org.inspector.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class PipeBodyDto {
    private String serialCode;
    private Double bodyUltraRwt;
    private Double bodyUltraEmiRwt;
    private Double bodyCoatingCond;
    private Integer bodyClassificationPc;
    private Integer bodyClassificationC2;
    private Integer bodyClassificationC3;
    private Integer bodyClassificationScrap;
    private List<String> bodyImages;
    private Double effectiveLength;
    private String remark;
    private String remarkDetail;
    private String bodyUltraRwtFraction;
    private String bodyUltraEmiRwtFraction;
    private String bodyCoatingCondFraction;
    private String effectiveLengthFraction;
}
