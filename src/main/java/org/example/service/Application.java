package org.example.service;

import static org.example.service.EndpointStore.getEndpoints;
import static org.example.service.exception.mapper.MapperStore.getMappers;

import org.wso2.msf4j.MicroservicesRunner;

public class Application {

    public static void main(String[] args) {
        new ServiceDeployer(new MicroservicesRunner(1234))
                .registerEndpoints(getEndpoints())
                .withExceptionMappers(getMappers())
                .start();
    }

}
