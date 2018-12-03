package com.wildBirds.cardvalidator.application;

import com.wildBirds.cardvalidator.application.DTO.IssuerDTO;
import com.wildBirds.cardvalidator.application.DTO.ValidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardValidatorController {


    @Autowired
    CheckSumService checkSumService;

    @Autowired
    IssuerCardService issuerCardService;

    @GetMapping("{innNumber}")
    public ResponseEntity validateCard(@PathVariable String innNumber){

        IssuerDTO nameIssuer = issuerCardService.getNameIssuer(innNumber);

        ValidateDTO validateDTO = checkSumService.checkCorrectSum(innNumber);

        System.out.println(validateDTO);
        System.out.println(nameIssuer);
        return null;
    }



}
