package org.inspector.core.mapper;

import org.inspector.core.dto.SiteDto;
import org.inspector.core.entity.Site;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface SiteMapper {
    @Mappings({
            @Mapping(target = "name", source = "siteName")
    })
    SiteDto toDto(Site site);

    @Mappings({
            @Mapping(target = "siteName", source = "name")
    })
    Site toEntity(SiteDto roleDto);
}
