package org.example.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.MicroservicesRunner;

public class ServiceDeployer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDeployer.class.getName());

    private final MicroservicesRunner runner;

    private final List<Class<?>> endpoints = new LinkedList<>();

    public ServiceDeployer(MicroservicesRunner runner) {
        Objects.requireNonNull(runner);
        this.runner = runner;
    }

    public MicroservicesRunner withExceptionMappers(List<ExceptionMapper> exceptionMapper) {
        exceptionMapper.forEach(mapper -> {
            LOGGER.info(String.format("Registering mapper for %s", mapper.getClass().getName().substring(mapper.getClass().getName().lastIndexOf('.') + 1)));
            runner.addExceptionMapper(mapper);
        });
        return runner;
    }

    public ServiceDeployer registerEndpoints(List<Class<?>> endpointsToRegister) {
        this.endpoints.addAll(endpointsToRegister);
        endpoints.forEach(service -> {
            LOGGER.info(String.format("Registering controller: %s", service.getName().substring(service.getName().lastIndexOf('.') + 1)));
            runner.deploy(instantiateEndpoint(service));
        });
        return this;
    }

    private static Object instantiateEndpoint(Class<?> endpoint) {
        try {
            return endpoint.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
