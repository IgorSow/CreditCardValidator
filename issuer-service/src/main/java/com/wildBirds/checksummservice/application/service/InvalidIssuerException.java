package com.wildBirds.checksummservice.application.service;

public class InvalidIssuerException extends RuntimeException{

    public InvalidIssuerException(String message) {
        super(message);
    }
}
