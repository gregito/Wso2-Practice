package org.example.service.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.Response;
import org.wso2.msf4j.interceptor.RequestInterceptor;

public class RequestLoggerInterceptor implements RequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggerInterceptor.class.getName());

    @Override
    public boolean interceptRequest(Request request, Response response) {
        LOGGER.info(String.format("Logging HTTP request { HTTPMethod: %s, URI: %s }", request.getHttpMethod(), request.getUri()));
        String propertyName = "SampleProperty";
        String property = "WSO2-2017";
        request.setProperty(propertyName, property);
        LOGGER.info(String.format("Property %s with value %s set to request", propertyName, property));
        return true;
    }
}
