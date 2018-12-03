package com.wildBirds.checksummservice.application;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.wildBirds.checksummservice.application.service.IssuerService;
import com.wildBirds.checksummservice.domain.model.Issuer;
import com.wildBirds.checksummservice.infrastructure.IssuerRepositoryIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class IssuerController {

    @Autowired
    IssuerRepositoryIml issuerRepositoryIml;

    @Autowired
    IssuerService issuerService;

    @GetMapping("/issuer/{innNumber}")
    public ResponseEntity getIssuer(@PathVariable String innNumber) {

        List<String> numberList = issuerService.splitNummber(innNumber);


        Issuer issuer = issuerRepositoryIml.getIssuer(numberList);

        IssuerDTO issuerDTO = issuerService.toIssuerDTO(issuer);

        return new ResponseEntity(issuerDTO, HttpStatus.OK);
    }
}
