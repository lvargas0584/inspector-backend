package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class PipeBox {
    // Box
    @BsonProperty("box_outside")
    private Double BoxOutside;

    @BsonProperty("box_bevel")
    private Double BoxBevel;

    @BsonProperty("box_shoulder")
    private Double BoxShoulder;

    @BsonProperty("box_bore_diam")
    private Double BoxBoreDiam;

    @BsonProperty("box_bore_depth")
    private Double BoxBoreDepth;

    @BsonProperty("box_tong")
    private Double BoxTong;

    @BsonProperty("box_hard_band_ht")
    private Double BoxHardBandHt;

    @BsonProperty("box_hard_band_apply")
    private String BoxHardBandApply;

    @BsonProperty("box_vt")
    private String BoxVt;

    @BsonProperty("box_final_cond")
    private String BoxFinalCond;

    @BsonProperty("box_outside_fraction")
    private String boxOutsideFraction;

    @BsonProperty("box_bevel_fraction")
    private String boxBevelFraction;

    @BsonProperty("box_shoulder_fraction")
    private String boxShoulderFraction;

    @BsonProperty("box_bore_diam_fraction")
    private String boxBoreDiamFraction;

    @BsonProperty("box_bore_depth_fraction")
    private String boxBoreDepthFraction;

    @BsonProperty("box_tong_fraction")
    private String boxTongFraction;

    @BsonProperty("box_images")
    private List<String> BoxImages;

    public String getBoxOutsideFraction() {
        return boxOutsideFraction;
    }

    public void setBoxOutsideFraction(String boxOutsideFraction) {
        this.boxOutsideFraction = boxOutsideFraction;
    }

    public String getBoxBevelFraction() {
        return boxBevelFraction;
    }

    public void setBoxBevelFraction(String boxBevelFraction) {
        this.boxBevelFraction = boxBevelFraction;
    }

    public String getBoxShoulderFraction() {
        return boxShoulderFraction;
    }

    public void setBoxShoulderFraction(String boxShoulderFraction) {
        this.boxShoulderFraction = boxShoulderFraction;
    }

    public String getBoxBoreDiamFraction() {
        return boxBoreDiamFraction;
    }

    public void setBoxBoreDiamFraction(String boxBoreDiamFraction) {
        this.boxBoreDiamFraction = boxBoreDiamFraction;
    }

    public String getBoxBoreDepthFraction() {
        return boxBoreDepthFraction;
    }

    public void setBoxBoreDepthFraction(String boxBoreDepthFraction) {
        this.boxBoreDepthFraction = boxBoreDepthFraction;
    }

    public String getBoxTongFraction() {
        return boxTongFraction;
    }

    public void setBoxTongFraction(String boxTongFraction) {
        this.boxTongFraction = boxTongFraction;
    }

    public Double getBoxOutside() {
        return BoxOutside;
    }

    public void setBoxOutside(Double boxOutside) {
        BoxOutside = boxOutside;
    }

    public Double getBoxBevel() {
        return BoxBevel;
    }

    public void setBoxBevel(Double boxBevel) {
        BoxBevel = boxBevel;
    }

    public Double getBoxShoulder() {
        return BoxShoulder;
    }

    public void setBoxShoulder(Double boxShoulder) {
        BoxShoulder = boxShoulder;
    }

    public Double getBoxBoreDiam() {
        return BoxBoreDiam;
    }

    public void setBoxBoreDiam(Double boxBoreDiam) {
        BoxBoreDiam = boxBoreDiam;
    }

    public Double getBoxBoreDepth() {
        return BoxBoreDepth;
    }

    public void setBoxBoreDepth(Double boxBoreDepth) {
        BoxBoreDepth = boxBoreDepth;
    }

    public Double getBoxTong() {
        return BoxTong;
    }

    public void setBoxTong(Double boxTong) {
        BoxTong = boxTong;
    }

    public Double getBoxHardBandHt() {
        return BoxHardBandHt;
    }

    public void setBoxHardBandHt(Double boxHardBandHt) {
        BoxHardBandHt = boxHardBandHt;
    }

    public String getBoxHardBandApply() {
        return BoxHardBandApply;
    }

    public void setBoxHardBandApply(String boxHardBandApply) {
        BoxHardBandApply = boxHardBandApply;
    }

    public String getBoxVt() {
        return BoxVt;
    }

    public void setBoxVt(String boxVt) {
        BoxVt = boxVt;
    }

    public String getBoxFinalCond() {
        return BoxFinalCond;
    }

    public void setBoxFinalCond(String boxFinalCond) {
        BoxFinalCond = boxFinalCond;
    }

    public List<String> getBoxImages() {
        return BoxImages;
    }

    public void setBoxImages(List<String> boxImages) {
        BoxImages = boxImages;
    }
}
