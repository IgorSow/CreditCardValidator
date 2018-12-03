package com.wildBirds.checksummservice.application.service;


import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class IssuerServiceTest {





    @Test
    public void shouldSplitNumberFromOneToSix() {
        //given
        IssuerService issuerService = new IssuerService();
        String creditCardNumber = "123456789012";
        //when
        issuerService.splitNummber(creditCardNumber);
        //then
    }

    @Test
    public void toIssuerDTO() {
    }
}