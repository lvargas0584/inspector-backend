package org.inspector.core.dto;

import lombok.Data;

@Data
public class PipeDto {
    private String id;
    private String serialCode;

    private PipePinDto pipePin;
    private PipeBoxDto pipeBox;
    private PipeBodyDto pipeBody;

    private String signature;
    private Double latitude;
    private Double longitude;
    private String address;
    private Boolean isDecimal = false;
}
