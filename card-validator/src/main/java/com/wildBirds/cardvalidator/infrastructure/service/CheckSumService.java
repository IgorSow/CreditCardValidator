package com.wildBirds.cardvalidator.infrastructure.service;


import com.wildBirds.cardvalidator.application.DTO.ValidateDTO;
import com.wildBirds.cardvalidator.infrastructure.service.exception.CheckSumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckSumService {

    @Value("${checksum.service.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ValidateDTO checkCorrectSum(String number) throws CheckSumException {
        ResponseEntity<ValidateDTO> checkSummResponse = null;
        try {
            checkSummResponse = restTemplate.getForEntity(serviceUrl + "/checksum/" + number, ValidateDTO.class);
            ValidateDTO validateDTO = checkSummResponse.getBody();
            return validateDTO;
        } catch (RestClientException e) {
            throw new CheckSumException(e.toString());
        }
    }
}
