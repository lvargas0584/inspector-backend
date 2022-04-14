package org.inspector.core.dto;

import lombok.Data;

import java.util.List;

@Data
public class PipePinDto {
    private String serialCode;
    private Double pinOutside;
    private Double pinInside;
    private Double pinBevel;
    private Double pinNeck;
    private Double pinLpc;
    private Double pinTong;
    private Double pinHardBandHt;
    private String pinHardBandApply;
    private String pinVt;
    private String pinFinalCond;
    private String pinOutsideFraction;
    private String pinInsideFraction;
    private String pinBevelFraction;
    private String pinNeckFraction;
    private String pinTongFraction;
    private List<String> pinImages;
}