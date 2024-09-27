package com.africa.semicolon.wazobia_app.exceptions;

public class WrongEmailFormatException extends RuntimeException {
    public WrongEmailFormatException(String message) {
        super(message);
    }
}
