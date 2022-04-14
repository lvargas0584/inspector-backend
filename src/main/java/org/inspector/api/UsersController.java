package org.inspector.api;

import org.inspector.core.dto.UserDto;
import org.inspector.core.service.UserService;

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

@Path("/inspector/users")
public class UsersController extends BaseController {

    @Inject
    UserService userService;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return buildSuccessWrapperResponse(userService.getUsers());
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{userId}")
    public Response getUser(@PathParam("userId") String userId) {
        return buildSuccessWrapperResponse(userService.getUser(userId));
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(UserDto userDto) {
        return buildSuccessWrapperResponse(userService.saveUser(userDto));
    }

    @PATCH
    @PermitAll
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") String userId, UserDto userDto) {
        return buildSuccessWrapperResponse(userService.updateUser(userDto, userId));
    }
}