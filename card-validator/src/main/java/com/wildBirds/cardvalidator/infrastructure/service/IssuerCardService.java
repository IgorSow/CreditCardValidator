package com.wildBirds.cardvalidator.infrastructure.service;


import com.wildBirds.cardvalidator.application.DTO.IssuerDTO;
import com.wildBirds.cardvalidator.infrastructure.service.exception.InvalidIssuerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class IssuerCardService {

    @Value("${issuer.finder.service.url}")
    String serviceUrl;

    @Autowired
    RestTemplate restTemplate;

    public IssuerDTO getNameIssuer(String number) throws InvalidIssuerException {
        try {
            ResponseEntity<IssuerDTO> issuerDTOResponse = restTemplate.getForEntity(serviceUrl + "/issuer/" + number, IssuerDTO.class);

            IssuerDTO issuerDTO = issuerDTOResponse.getBody();

            return issuerDTO;
        } catch (RestClientException e) {
            throw new InvalidIssuerException(e.getMessage());
        }
    }




}
