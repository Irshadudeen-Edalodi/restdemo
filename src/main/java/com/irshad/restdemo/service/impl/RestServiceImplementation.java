package com.irshad.restdemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irshad.restdemo.model.User;
import com.irshad.restdemo.service.RestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
@Slf4j
@AllArgsConstructor
public class RestServiceImplementation implements RestService {

    private final RestTemplate restTemplate;
    @Override
    public String register(User user) throws JsonProcessingException {
        //String body = "{}"
        ObjectMapper objectMapper = new ObjectMapper();
        String regUrl = "http://restapi.adequateshop.com/api/AuthAccount/Registration";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(user),headers);

        HttpEntity<String> response = restTemplate.exchange(regUrl, HttpMethod.POST,request,String.class);
        return response.getBody();
    }
}
