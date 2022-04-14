package org.inspector.core.dto;

import lombok.Data;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
@Data
public class MultipartBodyDto {

    @NotNull
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream file;

    @NotNull
    @PartType(MediaType.TEXT_PLAIN)
    @FormParam("type")
    public String type;

    @NotNull
    @PartType(MediaType.TEXT_PLAIN)
    @FormParam("serialCode")
    public String serialCode;

    @NotNull
    @PartType(MediaType.TEXT_PLAIN)
    @FormParam("workOrderId")
    public String workOrderId;

}
