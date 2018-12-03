package com.wildBirds.cardvalidator.application;


import com.wildBirds.cardvalidator.application.DTO.IssuerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssuerCardService {

    @Value("${issuer.finder.service.url}")
    String serviceUrl;

    @Autowired
    RestTemplate restTemplate;

    public IssuerDTO getNameIssuer(String number){
        ResponseEntity<IssuerDTO> issuerDTOResponse = restTemplate.getForEntity(serviceUrl + "/issuer/" + number, IssuerDTO.class);

        IssuerDTO issuerDTO = issuerDTOResponse.getBody();

        return issuerDTO;
    }




}
