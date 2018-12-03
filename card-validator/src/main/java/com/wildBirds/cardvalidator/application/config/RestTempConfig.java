package com.wildBirds.cardvalidator.application.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
