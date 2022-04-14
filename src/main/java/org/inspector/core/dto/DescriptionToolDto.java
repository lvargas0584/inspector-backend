package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class DescriptionToolDto {
    private ObjectId id;
    private String name;
    private String shortName;
}
