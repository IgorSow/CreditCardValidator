package com.wildBirds.checksummservice.application.service;

import com.wildBirds.checksummservice.application.IssuerDTO;
import com.wildBirds.checksummservice.domain.model.Issuer;
import com.wildBirds.checksummservice.infrastructure.IssuerRepositoryIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json; charset=UTF-8");
        header.add("X-Fsl-Location", "/");
        header.add("X-Fsl-Response-Code", "302");

        if (issuerService.isCorrectLength(innNumber)) {

            List<String> numberList = issuerService.splitNummber(innNumber);

            Issuer issuer = issuerRepositoryIml.getIssuer(numberList);

            IssuerDTO issuerDTO = issuerService.toIssuerDTO(issuer);

            header.add("OK", "CorrectNumber");
            return new ResponseEntity(issuerDTO, header, HttpStatus.OK);
        } else {
            header.add("Error", "Not appropriate length hav to 12 to 19  ");
            return new ResponseEntity(header, HttpStatus.NOT_FOUND);
        }
    }
}
