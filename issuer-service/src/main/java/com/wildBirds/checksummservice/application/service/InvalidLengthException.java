package com.wildBirds.checksummservice.application.service;

public class InvalidLengthException extends RuntimeException {

    public InvalidLengthException(String message) {
        super(message);
    }
}
