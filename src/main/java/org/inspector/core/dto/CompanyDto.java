package org.inspector.core.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class CompanyDto {
    private ObjectId id;
    private String ruc;
    private String name;
    private List<SiteDto> sites;
}
