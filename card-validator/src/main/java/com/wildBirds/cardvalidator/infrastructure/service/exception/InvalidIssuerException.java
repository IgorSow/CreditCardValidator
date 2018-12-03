package com.wildBirds.cardvalidator.infrastructure.service.exception;

import org.springframework.web.client.RestClientException;

public class InvalidIssuerException extends RestClientException {

    public InvalidIssuerException(String msg) {
        super(msg);
    }
}
