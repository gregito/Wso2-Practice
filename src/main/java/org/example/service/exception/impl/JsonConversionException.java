package org.example.service.exception.impl;

public class JsonConversionException extends RuntimeException {

    public JsonConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
