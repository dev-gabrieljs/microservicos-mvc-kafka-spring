package com.portal.api.exeptions.custom;

public class HttpServerErrorException extends RuntimeException {
    public HttpServerErrorException(String message) {
        super(message);
    }
}
