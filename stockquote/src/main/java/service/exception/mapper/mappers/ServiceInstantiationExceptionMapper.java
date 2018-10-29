package service.exception.mapper.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.exception.impl.ServiceInstantiationException;

public class ServiceInstantiationExceptionMapper implements ExceptionMapper<ServiceInstantiationException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInstantiationExceptionMapper.class);

    @Override
    public Response toResponse(ServiceInstantiationException e) {
        LOGGER.error("Unable to instantiate service!", e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
