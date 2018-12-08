package com.wildBirds.cardvalidator.application;

import com.wildBirds.cardvalidator.CardValidatorApplication;
import com.wildBirds.cardvalidator.application.DTO.IssuerDTO;
import com.wildBirds.cardvalidator.application.DTO.ValidateDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CardValidatorApplication.class)
public class IssuerCardServiceTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    final String serverAdress = "http://localhost:8091";

    @Test
    public void shouldReturnVisa() {
        //given
        final String visa = "4516895819549900";
        final String expectedCard = "Visa";
        //when

        String acctualResponse = testRestTemplate.getForEntity(serverAdress + "/issuer/" + visa, IssuerDTO.class).getBody().getName();
        //then

        Assert.assertEquals(expectedCard,acctualResponse);
    }
//    375788678114858

}