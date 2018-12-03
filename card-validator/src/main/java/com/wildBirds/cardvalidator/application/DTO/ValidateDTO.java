package com.wildBirds.cardvalidator.application.DTO;


public class ValidateDTO {

    private boolean isCheckSumCorrect;

    public ValidateDTO() {
    }

    public boolean getIsCheckSumCorrect() {
        return isCheckSumCorrect;
    }

    public void setIsCheckSumCorrect(boolean isCheckSumCorrect) {
        this.isCheckSumCorrect = isCheckSumCorrect;
    }

    @Override
    public String toString() {
        return "ValidateDTO{" +
                "isCheckSumCorrect=" + isCheckSumCorrect +
                '}';
    }
}
