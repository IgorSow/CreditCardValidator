package com.wildBirds.checksummservice.application;

import com.wildBirds.checksummservice.IssuerServiceApp;
import com.wildBirds.checksummservice.application.service.IssuerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = IssuerServiceApp.class)
public class IssuerControllerTest {


    @LocalServerPort
    int serviceHost;


    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    IssuerService issuerService;



    @Test
    public void shouldReturnVisaCard() {

        //given
        final String innNumber = "4186786217456229";
        final String expectedCard = "Visa";

        //when

        ResponseEntity<IssuerDTO> restTemplateForEntity = restTemplate.getForEntity("http://localhost:" + serviceHost + "/issuer/" + innNumber, IssuerDTO.class);
        //then

        IssuerDTO issuerDTO = restTemplateForEntity.getBody();

        Assert.assertEquals(expectedCard, issuerDTO.getName());
    }
    @Test
    public void shouldReturnNoCard() {

        //given
        final String innNumber = "9986786217456229";
        final String expectedCard = null;

        //when

        ResponseEntity<IssuerDTO> restTemplateForEntity = restTemplate.getForEntity("http://localhost:" + serviceHost + "/issuer/" + innNumber, IssuerDTO.class);
        //then

        IssuerDTO issuerDTO = restTemplateForEntity.getBody();

        Assert.assertEquals(expectedCard, issuerDTO.getName());
    }

    @Test
    public void shouldReturnPropertyLength() {

        //given
        final String innNumber = "4186786217456229";
        final String expectedCard = "Visa";

        //when

        ResponseEntity<IssuerDTO> restTemplateForEntity = restTemplate.getForEntity("http://localhost:" + serviceHost + "/issuer/" + innNumber, IssuerDTO.class);
        //then

        IssuerDTO issuerDTO = restTemplateForEntity.getBody();

        Assert.assertEquals(expectedCard, issuerDTO.getName());
    }
}