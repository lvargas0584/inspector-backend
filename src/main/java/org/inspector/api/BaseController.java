package org.inspector.api;

import javax.ws.rs.core.Response;
import java.util.List;

public class BaseController {

    public BaseController() {
    }

    public <T> Response buildSuccessWrapperResponse(List<T> list) {
        return Response.status(Response.Status.ACCEPTED).entity(list).build();
    }

    public <T> Response buildOkSuccessWrapperResponse(T data) {
        return Response.status(Response.Status.OK).entity(data).build();
    }

    public <T> Response buildSuccessWrapperResponse(T data) {
        return Response.status(Response.Status.ACCEPTED).entity(data).build();
    }

    public <T> Response buildSuccessWrapperResponse() {
        return Response.status(Response.Status.ACCEPTED).build();
    }

    public <T> Response buildEmptySuccessWrapperResponse() {
        return Response.status(Response.Status.ACCEPTED).build();
    }

    public <T> Response buildBadRequestWrapperResponse(T data) {
        return Response.status(Response.Status.BAD_REQUEST).entity(data).build();
    }

    public <T> Response buildNotFoundWrapperResponse(T data) {
        return Response.status(Response.Status.NOT_FOUND).entity(data).build();
    }

    public <T> Response buildInternalServerErrorWrapperResponse(T data) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(data).build();
    }
}
