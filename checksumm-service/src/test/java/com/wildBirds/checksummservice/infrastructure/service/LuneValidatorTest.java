package com.wildBirds.checksummservice.infrastructure.service;

import com.wildBirds.checksummservice.domain.ports.LunarValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuneValidatorTest {

    private LunarValidator lunarValidator;

    @Before
    public void init() {
        lunarValidator = new LuneValidatorIml();

    }

    @Test
    public void shouldValidateLunarAlgorythm() {
        //given
        final String correctNumber = "67533";
        //when
        boolean validate = lunarValidator.validate(correctNumber);
        //then
        Assert.assertTrue(validate);
    }

    @Test
    public void shouldNotValidateLunarAlgorythm() {
        //given
        final String inCorrectNumber = "675333";
        //when

        boolean validate = false;
        try {
            validate = lunarValidator.validate(inCorrectNumber);

            Assert.assertFalse(true);
            //then

        } catch (LunarValidatorException e) {
            Assert.assertFalse(false);
        }

    }

}