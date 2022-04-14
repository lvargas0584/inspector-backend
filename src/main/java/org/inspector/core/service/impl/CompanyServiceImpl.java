package org.inspector.core.service.impl;

import org.bson.types.ObjectId;
import org.inspector.core.dto.CompanyDto;
import org.inspector.core.entity.Company;
import org.inspector.core.entity.Site;
import org.inspector.core.entity.User;
import org.inspector.core.mapper.CompanyMapper;
import org.inspector.core.mapper.SiteMapper;
import org.inspector.core.service.CompanyService;
import org.inspector.core.util.Util;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CompanyServiceImpl implements CompanyService {

    @Inject
    CompanyMapper companyMapper;

    @Inject
    SiteMapper siteMapper;

    @Override
    public List<CompanyDto> getCompanies() {
        return Company.findAll().stream()
                .map(e -> companyMapper.toDto((Company) e))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto getCompanyById(String companyId) {
        return Company.findByIdOptional(new ObjectId(companyId))
                .map(e -> companyMapper.toDto((Company) e))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public CompanyDto saveCompany(CompanyDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        company.persistOrUpdate();
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto updateCompany(String companyId, CompanyDto companyDto) {
        Company company = (Company) Company.findByIdOptional(new ObjectId(companyId))
                .orElseThrow(NotFoundException::new);
        if (!Util.isNullOrEmpty(companyDto.getName())) {
            company.setCompanyName(company.getCompanyName());
        }
        List<Site> sites = companyDto.getSites().stream()
                .map(d -> {
                    if (Util.isNullOrEmpty(d.getId())) {
                        d.setId(Util.generateUUID());
                    }
                    return siteMapper.toEntity(d);
                })
                .collect(Collectors.toList());
        company.setSites(sites);

        company.persistOrUpdate();

        return companyMapper.toDto(company);
    }
}
