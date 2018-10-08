package org.example.service.exception.mapper.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.example.service.exception.impl.JsonConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonConversionExceptionMapper implements ExceptionMapper<JsonConversionException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConversionExceptionMapper.class);

    @Override
    public Response toResponse(JsonConversionException e) {
        LOGGER.warn(e.getMessage(), e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
