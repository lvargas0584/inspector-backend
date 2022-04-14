package org.inspector.api;

import org.inspector.core.dto.CompanyDto;
import org.inspector.core.service.CompanyService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inspector/companies")
public class CompaniesController extends BaseController {

    @Inject
    CompanyService companyService;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanies() {
        return buildSuccessWrapperResponse(companyService.getCompanies());
    }

    @GET
    @Path("{companyId}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyById(@PathParam("companyId") String companyId) {
        return buildSuccessWrapperResponse(companyService.getCompanyById(companyId));
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCompany(CompanyDto companyDto) {
        return buildSuccessWrapperResponse(companyService.saveCompany(companyDto));
    }

    @PUT
    @Path("{companyId}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCompany(@PathParam("companyId") String companyId, CompanyDto companyDto) {
        return buildSuccessWrapperResponse(companyService.updateCompany(companyId, companyDto));
    }
}
