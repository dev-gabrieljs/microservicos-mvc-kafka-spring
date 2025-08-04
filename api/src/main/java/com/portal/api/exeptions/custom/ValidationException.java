package com.portal.api.exeptions.custom;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
