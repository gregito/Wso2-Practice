package org.example.service.exception.mapper.mappers;

import static org.example.service.exception.ResponseType.PLAIN_TEXT;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.example.service.exception.impl.AccessDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessDeniedExceptionMapper.class);

    @Override
    public Response toResponse(AccessDeniedException e) {
        LOGGER.warn(e.getMessage());
        return Response.status(Response.Status.FORBIDDEN).type(PLAIN_TEXT.getValue()).entity("Access denied!").build();
    }

}
