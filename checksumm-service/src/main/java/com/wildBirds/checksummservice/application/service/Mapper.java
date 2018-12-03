package com.wildBirds.checksummservice.application.service;

import com.wildBirds.checksummservice.application.ValidateDTO;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ValidateDTO toValidateDTO(boolean validate) {
        ValidateDTO validateDTO = new ValidateDTO();
        validateDTO.setInnNumber(validate);
        return validateDTO;
    }
}
