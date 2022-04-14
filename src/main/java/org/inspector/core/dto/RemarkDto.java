package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class RemarkDto {
    private ObjectId id;
    private String code;
    private String text;
}
