package com.wildBirds.checksummservice.infrastructure.service;


import com.wildBirds.checksummservice.domain.ports.LunarValidator;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class LuneValidatorIml implements LunarValidator {

    @Override
    public boolean validate(String number) throws LunarValidatorException{
        number = removeSpace(number);

        int[] numbersIntArray = convertStringToTableOfInteger(number);
        int summToCheck = 0;

        for (int i = 0; i < numbersIntArray.length; i++) {

            if (i % 2 == 0) {
                int tempSum;
                tempSum = numbersIntArray[i] * 2;
                summToCheck += isLesThenTen(tempSum);
            } else {
                summToCheck += numbersIntArray[i];
            }
        }
        return validStatement(summToCheck);

    }

    private String removeSpace(String number) {
        return number.replace(" ", "");
    }

    private boolean validStatement(int sumToCheck) throws LunarValidatorException {
        if (sumToCheck % 10 == 0) {
            return true;
        } else {
            throw new LunarValidatorException("In correct number");
        }
    }

    private int isLesThenTen(int tempSumm) {
        if (tempSumm >= 10) {
            return tempSumm - 9;
        } else {
            return tempSumm;
        }
    }

    private int[] convertStringToTableOfInteger(String number) {
        return Stream.of(number.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
