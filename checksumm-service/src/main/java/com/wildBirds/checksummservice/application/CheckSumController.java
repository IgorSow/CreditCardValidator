package com.wildBirds.checksummservice.application;


import com.wildBirds.checksummservice.application.service.Mapper;
import com.wildBirds.checksummservice.domain.ports.LunarValidator;
import com.wildBirds.checksummservice.infrastructure.service.LunarValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckSumController {

    @Autowired
    LunarValidator lunarValidator;

    @Autowired
    Mapper mapper;

    @GetMapping("checksum/{innNumber}")
    public ResponseEntity checkCard(@PathVariable String innNumber){

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json; charset=UTF-8");
        header.add("X-Fsl-Location", "/");
        header.add("X-Fsl-Response-Code", "302");

        try {
            boolean validate = lunarValidator.validate(innNumber);
            ValidateDTO validateDTO = mapper.toValidateDTO(validate);
            header.add("OK", "Validated number");
            return new ResponseEntity(validateDTO,header, HttpStatus.OK);
        } catch (LunarValidatorException e) {
            boolean validate = false;
            ValidateDTO validateDTO = mapper.toValidateDTO(validate);

            header.add("Error", "Not validated number");
            return new ResponseEntity(validateDTO, header, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
