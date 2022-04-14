package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class PipeBody {
    @BsonProperty("body_ultra_rwt")
    private Double BodyUltraRwt;

    @BsonProperty("body_ultra_emi_wt")
    private Double BodyUltraEmiRwt;

    @BsonProperty("body_coating_cond")
    private Double BodyCoatingCond;

    @BsonProperty("body_class_pc")
    private Integer BodyClassificationPc;

    @BsonProperty("body_class_c2")
    private Integer BodyClassificationC2;

    @BsonProperty("body_class_c3")
    private Integer BodyClassificationC3;

    @BsonProperty("body_class_scrap")
    private Integer BodyClassificationScrap;

    @BsonProperty("body_images")
    private List<String> BodyImages;

    @BsonProperty("effective_length")
    private Double EffectiveLength;

    @BsonProperty("remark")
    private String Remark;

    @BsonProperty("remark_detail")
    private String RemarkDetail;

    @BsonProperty("body_ultra_rwt_fraction")
    private String bodyUltraRwtFraction;

    @BsonProperty("body_ultra_emi_rwt_fraction")
    private String bodyUltraEmiRwtFraction;

    @BsonProperty("body_coating_cond_fraction")
    private String bodyCoatingCondFraction;

    @BsonProperty("effective_length_fraction")
    private String effectiveLengthFraction;

    public String getBodyUltraRwtFraction() {
        return bodyUltraRwtFraction;
    }

    public void setBodyUltraRwtFraction(String bodyUltraRwtFraction) {
        this.bodyUltraRwtFraction = bodyUltraRwtFraction;
    }

    public String getBodyUltraEmiRwtFraction() {
        return bodyUltraEmiRwtFraction;
    }

    public void setBodyUltraEmiRwtFraction(String bodyUltraEmiRwtFraction) {
        this.bodyUltraEmiRwtFraction = bodyUltraEmiRwtFraction;
    }

    public String getBodyCoatingCondFraction() {
        return bodyCoatingCondFraction;
    }

    public void setBodyCoatingCondFraction(String bodyCoatingCondFraction) {
        this.bodyCoatingCondFraction = bodyCoatingCondFraction;
    }

    public String getEffectiveLengthFraction() {
        return effectiveLengthFraction;
    }

    public void setEffectiveLengthFraction(String effectiveLengthFraction) {
        this.effectiveLengthFraction = effectiveLengthFraction;
    }

    public Double getBodyUltraRwt() {
        return BodyUltraRwt;
    }

    public void setBodyUltraRwt(Double bodyUltraRwt) {
        BodyUltraRwt = bodyUltraRwt;
    }

    public Double getBodyUltraEmiRwt() {
        return BodyUltraEmiRwt;
    }

    public void setBodyUltraEmiRwt(Double bodyUltraEmiRwt) {
        BodyUltraEmiRwt = bodyUltraEmiRwt;
    }

    public Double getBodyCoatingCond() {
        return BodyCoatingCond;
    }

    public void setBodyCoatingCond(Double bodyCoatingCond) {
        BodyCoatingCond = bodyCoatingCond;
    }

    public Integer getBodyClassificationPc() {
        return BodyClassificationPc;
    }

    public void setBodyClassificationPc(Integer bodyClassificationPc) {
        BodyClassificationPc = bodyClassificationPc;
    }

    public Integer getBodyClassificationC2() {
        return BodyClassificationC2;
    }

    public void setBodyClassificationC2(Integer bodyClassificationC2) {
        BodyClassificationC2 = bodyClassificationC2;
    }

    public Integer getBodyClassificationC3() {
        return BodyClassificationC3;
    }

    public void setBodyClassificationC3(Integer bodyClassificationC3) {
        BodyClassificationC3 = bodyClassificationC3;
    }

    public Integer getBodyClassificationScrap() {
        return BodyClassificationScrap;
    }

    public void setBodyClassificationScrap(Integer bodyClassificationScrap) {
        BodyClassificationScrap = bodyClassificationScrap;
    }

    public List<String> getBodyImages() {
        return BodyImages;
    }

    public void setBodyImages(List<String> bodyImages) {
        BodyImages = bodyImages;
    }

    public Double getEffectiveLength() {
        return EffectiveLength;
    }

    public void setEffectiveLength(Double effectiveLength) {
        EffectiveLength = effectiveLength;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getRemarkDetail() {
        return RemarkDetail;
    }

    public void setRemarkDetail(String remarkDetail) {
        RemarkDetail = remarkDetail;
    }
}
