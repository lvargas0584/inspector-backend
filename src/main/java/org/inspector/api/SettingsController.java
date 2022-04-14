package org.inspector.api;

import org.inspector.core.dto.DescriptionToolDto;
import org.inspector.core.dto.InspectionTypeDto;
import org.inspector.core.dto.RemarkDto;
import org.inspector.core.dto.UsedSpecificationDto;
import org.inspector.core.service.SettingsService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inspector/settings")
public class SettingsController extends BaseController {

    @Inject
    SettingsService settingsService;

    @GET
    @Path("inspection-types")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInspectionTypes() {
        return buildSuccessWrapperResponse(settingsService.getInspectionTypes());
    }

    @POST
    @Path("inspection-types")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveInspectionType(InspectionTypeDto inspectionTypeDto) {
        return buildSuccessWrapperResponse(settingsService.saveInspectionType(inspectionTypeDto));
    }

    @PATCH
    @Path("inspection-types/{inspectionTypeId}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateInspectionType(@PathParam("inspectionTypeId") String inspectionTypeId, InspectionTypeDto inspectionTypeDto) {
        return buildSuccessWrapperResponse(settingsService.updateInspectionType(inspectionTypeId, inspectionTypeDto));
    }

    @GET
    @Path("used-specifications")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsedSpecifications() {
        return buildSuccessWrapperResponse(settingsService.getUsedSpecifications());
    }

    @POST
    @Path("used-specifications")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUsedSpecification(UsedSpecificationDto usedSpecificationDto) {
        return buildSuccessWrapperResponse(settingsService.saveUsedSpecification(usedSpecificationDto));
    }

    @PATCH
    @Path("used-specifications/{usedSpecificationId}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDescriptionTools(@PathParam("usedSpecificationId") String usedSpecificationId, UsedSpecificationDto usedSpecificationDto) {
        return buildSuccessWrapperResponse(settingsService.updateUsedSpecification(usedSpecificationId, usedSpecificationDto));
    }

    @GET
    @Path("description-tools")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDescriptionTools() {
        return buildSuccessWrapperResponse(settingsService.getDescriptionTools());
    }

    @POST
    @Path("description-tools")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveDescriptionTool(DescriptionToolDto descriptionToolDto) {
        return buildSuccessWrapperResponse(settingsService.saveDescriptionTool(descriptionToolDto));
    }

    @PATCH
    @Path("description-tools/{descriptionToolId}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDescriptionTools(@PathParam("descriptionToolId") String descriptionToolId, DescriptionToolDto descriptionToolDto) {
        return buildSuccessWrapperResponse(settingsService.updateDescriptionTool(descriptionToolId, descriptionToolDto));
    }

    @GET
    @Path("remarks")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRemarks() {
        return buildSuccessWrapperResponse(settingsService.getRemarks());
    }

    @POST
    @Path("remarks")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveRemark(RemarkDto remarkDto) {
        return buildSuccessWrapperResponse(settingsService.saveRemark(remarkDto));
    }
}