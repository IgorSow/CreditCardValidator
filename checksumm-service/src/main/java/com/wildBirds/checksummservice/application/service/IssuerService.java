package com.wildBirds.checksummservice.application.service;


import com.wildBirds.checksummservice.application.IssuerDTO;
import com.wildBirds.checksummservice.domain.model.Issuer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IssuerService {


    public List<String> splitNummber(String integer) {

        List<String> numberList = new ArrayList<>();

        String numberInString = String.valueOf(integer);


        for (Integer i = 1; i < 7; i++) {

            String substring = numberInString.substring(0, i);

            numberList.add(substring);
        }

        return numberList;
    }

    public IssuerDTO toIssuerDTO(Issuer issuer){
        IssuerDTO issuerDTO = new IssuerDTO();

        issuerDTO.setName(issuer.getIssuerName());

        return issuerDTO;
    }

}
