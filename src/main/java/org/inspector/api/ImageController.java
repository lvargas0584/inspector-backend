package org.inspector.api;

import org.apache.commons.io.FileUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.inspector.core.dto.MultipartBodyDto;
import org.inspector.core.util.Util;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

@Path("/inspector/images")
public class ImageController extends BaseController {
	
    private final Logger log = LoggerFactory.getLogger(ImageController.class);
    
    @ConfigProperty(name = "inspector.resources.images")
    String imagePath;
    
    @POST
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response save(@Valid @MultipartForm MultipartBodyDto bodyDto) throws IOException {
        String format = MessageFormat.format(imagePath, bodyDto.workOrderId, bodyDto.serialCode, bodyDto.type);
        log.debug("Mike " + imagePath);
        log.debug(bodyDto.serialCode);
        log.debug(bodyDto.type);
        log.debug(format);
        File image = new File(format + bodyDto.serialCode + "-" + bodyDto.type +"-"+ Util.randomIdentifier()+".png");
        FileUtils.copyInputStreamToFile(bodyDto.file, image);
        log.debug(image.getAbsolutePath());
        
        return buildSuccessWrapperResponse();
    }
}