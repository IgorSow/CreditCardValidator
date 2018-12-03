package com.wildBirds.checksummservice.application;

import com.wildBirds.checksummservice.ChecksummServiceApplication;
import com.wildBirds.checksummservice.application.service.IssuerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ChecksummServiceApplication.class)
public class IssuerControllerTest {


    int serviceHost = 8091;


    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    IssuerService issuerService;

    @Test
    public void shouldSplitValue() {
        //given
        String number = "52352352352352352355";
        //when
        List<String> integerList = issuerService.splitNummber(number);

        //then
        for (String number2 : integerList) {
            System.out.println(number2);
        }
    }

    @Test
    public void shouldReturnVisaCard() {

        //given
        final Integer innNumber = 463634642;
        final String expectedCard = "Visa";

        //when

        ResponseEntity<IssuerDTO> restTemplateForEntity = restTemplate.getForEntity("http://localhost:" + serviceHost + "/issuer/" + innNumber, IssuerDTO.class);
        //then

        IssuerDTO issuerDTO = restTemplateForEntity.getBody();

        Assert.assertEquals(expectedCard, issuerDTO.getName());
    }
}