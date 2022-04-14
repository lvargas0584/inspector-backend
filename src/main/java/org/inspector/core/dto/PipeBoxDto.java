package org.inspector.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class PipeBoxDto {
    private String serialCode;
    private Double boxOutside;
    private Double boxBevel;
    private Double boxShoulder;
    private Double boxBoreDiam;
    private Double boxBoreDepth;
    private Double boxTong;
    private Double boxHardBandHt;
    private String boxHardBandApply;
    private String boxVt;
    private String boxFinalCond;
    private String boxOutsideFraction;
    private String boxBevelFraction;
    private String boxShoulderFraction;
    private String boxBoreDiamFraction;
    private String boxBoreDepthFraction;
    private String boxTongFraction;
    private List<String> boxImages;
}