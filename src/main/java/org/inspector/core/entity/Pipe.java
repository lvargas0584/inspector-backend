package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Pipe {

    @BsonProperty("id")
    private String Id;

    @BsonProperty("serial_code")
    private String SerialCode;

    @BsonProperty("pipe_pin")
    private PipePin PipePin;

    @BsonProperty("pipe_box")
    private PipeBox PipeBox;

    @BsonProperty("pipe_body")
    private PipeBody PipeBody;

    @BsonProperty("signature")
    private String Signature;

    @BsonProperty("latitude")
    private Double Latitude;

    @BsonProperty("longitude")
    private Double Longitude;

    @BsonProperty("address")
    private String Address;

    @BsonProperty("is_decimal")
    private Boolean isDecimal;

    public Boolean getDecimal() {
        return isDecimal;
    }

    public void setDecimal(Boolean decimal) {
        isDecimal = decimal;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSerialCode() {
        return SerialCode;
    }

    public void setSerialCode(String serialCode) {
        SerialCode = serialCode;
    }

    public PipePin getPipePin() {
        return PipePin;
    }

    public void setPipePin(PipePin pipePin) {
        PipePin = pipePin;
    }

    public PipeBox getPipeBox() {
        return PipeBox;
    }

    public void setPipeBox(PipeBox pipeBox) {
        PipeBox = pipeBox;
    }

    public PipeBody getPipeBody() {
        return PipeBody;
    }

    public void setPipeBody(PipeBody pipeBody) {
        PipeBody = pipeBody;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}