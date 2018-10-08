package org.example.service.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.Response;
import org.wso2.msf4j.interceptor.ResponseInterceptor;

public class ResponseLoggerInterceptor implements ResponseInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseLoggerInterceptor.class.getName());

    @Override
    public boolean interceptResponse(Request request, Response response) {
        LOGGER.info("Logging HTTP response");
        String propertyName = "SampleProperty";
        String property = (String) request.getProperty(propertyName);
        LOGGER.info(String.format("Value of property %s is %s ", propertyName, property));
        return true;
    }
}
