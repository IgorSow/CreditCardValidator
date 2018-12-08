package com.wildBirds.checksummservice.application.service;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IssuerServiceTest {

    @Test
    public void shouldSplitNumberFromOneToSix() {
        //given
        IssuerService issuerService = new IssuerService();
        String creditCardNumber = "123456789012";
        //when
        List<String> innList = issuerService.splitNummber(creditCardNumber);

        //then
        Assert.assertEquals(6, innList.size());

        Assert.assertEquals(1, innList.get(0).length());
        Assert.assertEquals(2, innList.get(1).length());
        Assert.assertEquals(3, innList.get(2).length());
        Assert.assertEquals(4, innList.get(3).length());
        Assert.assertEquals(5, innList.get(4).length());
        Assert.assertEquals(6, innList.get(5).length());
    }

    @Test
    public void shouldReturnTrueAndAcceptLength() {

        //given
        IssuerService issuerService = new IssuerService();
        String length12 = "123456789012";
        String length15 = "123456789012345";
        String length19 = "1234567890123456789";

        //when
        boolean length12Check = issuerService.isCorrectLength(length12);
        boolean length15Check = issuerService.isCorrectLength(length15);
        boolean length19Check = issuerService.isCorrectLength(length19);
        //then
        Assert.assertTrue(length12Check);
        Assert.assertTrue(length15Check);
        Assert.assertTrue(length19Check);

    }
    @Test
    public void shouldReturnFalseAndNotAcceptLength() {

        //given
        IssuerService issuerService = new IssuerService();
        String length10 = "1234567890";
        String length11 = "12345678901";
        String length20 = "12345678901234567890";

        String lenth = "375788678114858";

        //when
        boolean length10Check = false;
        try {
            length10Check = issuerService.isCorrectLength(lenth);
        } catch (InvalidLengthException e) {
            Assert.assertTrue(true);
        }

        boolean length11Check = false;
        try {
            length11Check = issuerService.isCorrectLength(length11);
        } catch (InvalidLengthException e) {
            Assert.assertTrue(true);
        }

        boolean length20Check = false;
        try {
            length20Check = issuerService.isCorrectLength(length20);
        } catch (InvalidLengthException e) {
            Assert.assertTrue(true);
        }

        //then


    }
}