package com.wildBirds.cardvalidator.application;

import com.wildBirds.cardvalidator.application.DTO.IssuerDTO;
import com.wildBirds.cardvalidator.application.DTO.ValidateDTO;
import com.wildBirds.cardvalidator.infrastructure.service.CheckSumService;
import com.wildBirds.cardvalidator.infrastructure.service.IssuerCardService;
import com.wildBirds.cardvalidator.infrastructure.service.exception.CheckSumException;
import com.wildBirds.cardvalidator.infrastructure.service.exception.InvalidIssuerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardValidatorController {


    @Autowired
    CheckSumService checkSumService;

    @Autowired
    IssuerCardService issuerCardService;

    @CrossOrigin
    @GetMapping("{innNumber}")

    public ResponseEntity validateCard(@PathVariable String innNumber){

        HttpHeaders header = new HttpHeaders();
//        header.add("Access-Control-Allow-Origin", "*");
        header.add("Content-Type", "application/json; charset=UTF-8");
        try {
            IssuerDTO nameIssuer = issuerCardService.getNameIssuer(innNumber);

            ValidateDTO validateDTO = checkSumService.checkCorrectSum(innNumber);

            System.out.println(validateDTO);
            System.out.println(nameIssuer);
            header.add("OK", "Card validated");
            return new ResponseEntity(nameIssuer,header, HttpStatus.OK);
        } catch (InvalidIssuerException e) {
            e.printStackTrace();
            // TODO: 03.12.2018 how to catch cause ?
            header.add("Error", "Credit Card not found");
            return new ResponseEntity(header, HttpStatus.NOT_FOUND);
        } catch (CheckSumException e) {
            // TODO: 03.12.2018 how to catch cause ?
            e.printStackTrace();
            header.add("Error", "Invalid number");
            return new ResponseEntity(header, HttpStatus.NOT_ACCEPTABLE);
        }

    }



}
