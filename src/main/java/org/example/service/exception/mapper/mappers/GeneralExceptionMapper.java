package org.example.service.exception.mapper.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralExceptionMapper.class);

    @Override
    public Response toResponse(Exception e) {
        LOGGER.error("Unexpected behaviour which has no specified ExceptionMapper!", e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
