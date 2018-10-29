package service;

import static service.EndpointStore.getEndpoints;
import static service.exception.mapper.MapperStore.getMappers;

import javax.ws.rs.InternalServerErrorException;

import org.wso2.msf4j.MicroservicesRunner;

public class Application {

    public static void main(String[] args) {
        new ServiceDeployer(new MicroservicesRunner(getServicePort()))
                .registerEndpoints(getEndpoints())
                .withExceptionMappers(getMappers())
                .start();
    }

    private static int getServicePort() {
        try {
            return Integer.parseInt(System.getenv("STOCK_QUOTE_SERVICE_PORT"));
        } catch (Exception e) {
            throw new InternalServerErrorException("Unable to define service port!", e);
        }
    }

}
