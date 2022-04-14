package org.inspector.api;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.inspector.core.service.impl.ReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/inspector/reports")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Inject
    ReportServiceImpl reportGenerate;

    @ConfigProperty(name = "inspector.resources.excel")
    String excelPath;


    @ConfigProperty(name = "inspector.resources.zip")
    String zipPath;

    @GET
    @PermitAll
    @Path("/drillpipe/{workOrderId}/xls")
    @Produces("application/vnd.ms-excel")
    public Response getFileInExcelFormat(@PathParam("workOrderId") String workOrderId) throws Exception {
        logger.info("File requested is : " + workOrderId);

        //Put some validations here such as invalid file name or missing file name
        if (workOrderId == null || workOrderId.isEmpty()) {
            Response.ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST);
            return response.build();
        }
        ;
        //Prepare a file object with file to return

        File file = new File(reportGenerate.generate(workOrderId));

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=" + file.getName());
        return response.build();
    }



    @GET
    @PermitAll
    @Path("/images/{workOrderId}/zip")
    @Produces("application/zip")
    public Response getFileInZipFormat(@PathParam("workOrderId") String workOrderId) {
        logger.info("File requested is : " + workOrderId);

        //Put some validations here such as invalid file name or missing file name
        if (workOrderId == null || workOrderId.isEmpty()) {
            Response.ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST);
            return response.build();
        }

        //Prepare a file object with file to return

        File file = new File(reportGenerate.generateZip(workOrderId));

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=" + file.getName());
        return response.build();
    }


}

