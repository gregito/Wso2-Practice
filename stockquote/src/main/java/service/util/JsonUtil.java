package service.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import service.exception.impl.JsonConversionException;

public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtil() {
    }

    public static String toJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (IOException e) {
            throw new JsonConversionException("Something went wrong during object to json string conversion", e);
        }
    }

}
