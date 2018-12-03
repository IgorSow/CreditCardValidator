package com.wildBirds.cardvalidator.application;

import com.wildBirds.cardvalidator.CardValidatorApplication;
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
public class CheckSumServiceTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    final String serveradress = "http://localhost:8092";

    @Test
    public void shouldValidateNumber() {
        //given
        final String correctNumber = "4186786217456229";
        //when
        boolean isCheckSumCorrect = testRestTemplate.getForEntity(serveradress + "/checksum/" + correctNumber, ValidateDTO.class).getBody().getIsCheckSumCorrect();

        //then
        Assert.assertTrue(isCheckSumCorrect);

    }
}