package service.exception.mapper.mappers;

import static service.exception.ResponseType.PLAIN_TEXT;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.exception.impl.SymbolNotFoundException;

public class SymbolNotFoundMapper implements ExceptionMapper<SymbolNotFoundException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SymbolNotFoundMapper.class);

    @Override
    public Response toResponse(SymbolNotFoundException e) {
        LOGGER.info(e.getMessage());
        return Response.status(Response.Status.FORBIDDEN).type(PLAIN_TEXT.getValue()).entity("Access denied!").build();
    }

}
