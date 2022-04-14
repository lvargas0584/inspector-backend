package org.inspector.api;

import org.inspector.core.dto.RoleDto;
import org.inspector.core.service.RoleService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inspector/roles")
public class RolesController extends BaseController {

    @Inject
    RoleService roleService;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles() {
        return buildSuccessWrapperResponse(roleService.getRoles());
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{roleId}")
    public Response getRole(@PathParam("roleId") String roleId) {
        return buildSuccessWrapperResponse(roleService.getRole(roleId));
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveRole(RoleDto roleDto) {
        return buildSuccessWrapperResponse(roleService.saveRole(roleDto));
    }
}