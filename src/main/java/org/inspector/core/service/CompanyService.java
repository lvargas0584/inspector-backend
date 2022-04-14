package org.inspector.core.service;

import org.inspector.core.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getCompanies();
    CompanyDto getCompanyById(String companyId);
    CompanyDto saveCompany(CompanyDto companyDto);
    CompanyDto updateCompany(String companyId, CompanyDto companyDto);
}
