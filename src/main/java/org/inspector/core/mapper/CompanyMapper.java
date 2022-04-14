package org.inspector.core.mapper;

import org.inspector.core.dto.CompanyDto;
import org.inspector.core.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi", uses = { SiteMapper.class })
public interface CompanyMapper {
    @Mappings({
            @Mapping(target = "name", source = "companyName")
    })
    CompanyDto toDto(Company site);

    @Mappings({
            @Mapping(target = "companyName", source = "name")
    })
    Company toEntity(CompanyDto roleDto);
}
