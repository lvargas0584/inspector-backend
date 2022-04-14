package org.inspector.api;

import org.inspector.core.dto.PipeDto;
import org.inspector.core.dto.WorkOrderDto;
import org.inspector.core.service.WorkOrderService;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inspector/work-orders")
public class WorkOrdersController extends BaseController {

    @Inject
    WorkOrderService workOrderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkOrders(@QueryParam("allScope") Boolean allScope) {
        return buildSuccessWrapperResponse(workOrderService.getWorkOrders(allScope));
    }

    @GET
    @Path("{workOrderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkOrder(@PathParam("workOrderId") String workOrderId) {
        return buildSuccessWrapperResponse(workOrderService.getWorkOrderById(workOrderId));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveWorkOrder(WorkOrderDto workOrderDto) {
        return buildSuccessWrapperResponse(workOrderService.saveWorkOrder(workOrderDto));
    }

    @PATCH
    @Path("{workOrderId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateWorkOrder(@PathParam("workOrderId") String workOrderId, WorkOrderDto workOrderDto) {
        return buildSuccessWrapperResponse(workOrderService.updateWorkOrder(workOrderId, workOrderDto));
    }

    @PATCH
    @Path("{workOrderId}/pipes/{pipeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response SyncPipe(@PathParam("workOrderId") String workOrderId,
                             @PathParam("pipeId") String pipeId, PipeDto pipeDto) {
        return buildSuccessWrapperResponse(workOrderService.updatePipeByWorkOrder(workOrderId, pipeId, pipeDto));
    }
}
