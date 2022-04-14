package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class InspectionTypeFields {
    @BsonProperty("pin")
    private List<String> Pin;

    @BsonProperty("box")
    private List<String> Box;

    @BsonProperty("body")
    private List<String> Body;

    public List<String> getPin() {
        return Pin;
    }

    public void setPin(List<String> pin) {
        Pin = pin;
    }

    public List<String> getBox() {
        return Box;
    }

    public void setBox(List<String> box) {
        Box = box;
    }

    public List<String> getBody() {
        return Body;
    }

    public void setBody(List<String> body) {
        Body = body;
    }
}