package org.example.service.exception.mapper.mappers;

import static org.example.service.exception.ResponseType.PLAIN_TEXT;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.example.service.exception.impl.SymbolNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolNotFoundMapper implements ExceptionMapper<SymbolNotFoundException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SymbolNotFoundMapper.class);

    @Override
    public Response toResponse(SymbolNotFoundException e) {
        LOGGER.info(e.getMessage());
        return Response.status(Response.Status.FORBIDDEN).type(PLAIN_TEXT.getValue()).entity("Access denied!").build();
    }

}
