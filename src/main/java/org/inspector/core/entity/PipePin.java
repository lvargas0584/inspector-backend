package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class PipePin {

    @BsonProperty("pin_outside")
    private Double PinOutside;

    @BsonProperty("pin_inside")
    private Double PinInside;

    @BsonProperty("pin_bevel")
    private Double PinBevel;

    @BsonProperty("pin_neck")
    private Double PinNeck;

    @BsonProperty("pin_lcp")
    private Double PinLpc;

    @BsonProperty("pin_tong")
    private Double PinTong;

    @BsonProperty("pin_hard_band_ht")
    private Double PinHardBandHt;

    @BsonProperty("pin_hard_band_apply")
    private String PinHardBandApply;

    @BsonProperty("pin_vt")
    private String PinVt;

    @BsonProperty("pin_final_cond")
    private String PinFinalCond;

    @BsonProperty("pin_outside_fraction")
    private String PinOutsideFraction;

    @BsonProperty("pin_inside_fraction")
    private String PinInsideFraction;

    @BsonProperty("pin_bevel_fraction")
    private String PinBevelFraction;

    @BsonProperty("pin_neck_fraction")
    private String PinNeckFraction;

    @BsonProperty("pin_tong_fraction")
    private String PinTongFraction;

    @BsonProperty("pin_images")
    private List<String> PinImages;

    public String getPinInsideFraction() {
        return PinInsideFraction;
    }

    public void setPinInsideFraction(String pinInsideFraction) {
        PinInsideFraction = pinInsideFraction;
    }

    public String getPinBevelFraction() {
        return PinBevelFraction;
    }

    public void setPinBevelFraction(String pinBevelFraction) {
        PinBevelFraction = pinBevelFraction;
    }

    public String getPinNeckFraction() {
        return PinNeckFraction;
    }

    public void setPinNeckFraction(String pinNeckFraction) {
        PinNeckFraction = pinNeckFraction;
    }

    public String getPinTongFraction() {
        return PinTongFraction;
    }

    public void setPinTongFraction(String pinTongFraction) {
        PinTongFraction = pinTongFraction;
    }


    public String getPinOutsideFraction() {
        return PinOutsideFraction;
    }

    public void setPinOutsideFraction(String pinOutsideFraction) {
        PinOutsideFraction = pinOutsideFraction;
    }

    public Double getPinOutside() {
        return PinOutside;
    }

    public void setPinOutside(Double pinOutside) {
        PinOutside = pinOutside;
    }

    public Double getPinInside() {
        return PinInside;
    }

    public void setPinInside(Double pinInside) {
        PinInside = pinInside;
    }

    public Double getPinBevel() {
        return PinBevel;
    }

    public void setPinBevel(Double pinBevel) {
        PinBevel = pinBevel;
    }

    public Double getPinNeck() {
        return PinNeck;
    }

    public void setPinNeck(Double pinNeck) {
        PinNeck = pinNeck;
    }

    public Double getPinLpc() {
        return PinLpc;
    }

    public void setPinLpc(Double pinLpc) {
        PinLpc = pinLpc;
    }

    public Double getPinTong() {
        return PinTong;
    }

    public void setPinTong(Double pinTong) {
        PinTong = pinTong;
    }

    public Double getPinHardBandHt() {
        return PinHardBandHt;
    }

    public void setPinHardBandHt(Double pinHardBandHt) {
        PinHardBandHt = pinHardBandHt;
    }

    public String getPinHardBandApply() {
        return PinHardBandApply;
    }

    public void setPinHardBandApply(String pinHardBandApply) {
        PinHardBandApply = pinHardBandApply;
    }

    public String getPinVt() {
        return PinVt;
    }

    public void setPinVt(String pinVt) {
        PinVt = pinVt;
    }

    public String getPinFinalCond() {
        return PinFinalCond;
    }

    public void setPinFinalCond(String pinFinalCond) {
        PinFinalCond = pinFinalCond;
    }

    public List<String> getPinImages() {
        return PinImages;
    }

    public void setPinImages(List<String> pinImages) {
        PinImages = pinImages;
    }


}
