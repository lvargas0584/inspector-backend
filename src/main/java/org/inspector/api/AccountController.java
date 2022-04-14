package org.inspector.api;

import org.inspector.core.dto.LoginDto;
import org.inspector.core.service.AccountService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inspector/account")
public class AccountController extends BaseController {

    @Inject
    AccountService accountService;

    @POST
    @Path("login")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto) {
        return buildSuccessWrapperResponse(accountService.login(loginDto));
    }
}