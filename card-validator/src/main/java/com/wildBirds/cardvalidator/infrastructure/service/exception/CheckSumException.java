package com.wildBirds.cardvalidator.infrastructure.service.exception;

import org.springframework.web.client.RestClientException;

public class CheckSumException extends RestClientException {
    public CheckSumException(String msg) {
        super(msg);
    }
}
