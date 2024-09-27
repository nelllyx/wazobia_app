package com.africa.semicolon.wazobia_app.exceptions;

public class DriverAlreadyExistsException extends RuntimeException {
    public DriverAlreadyExistsException(String messages) {
        super(messages);
    }
}
