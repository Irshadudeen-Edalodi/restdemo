package com.irshad.restdemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irshad.restdemo.model.AppUser;
import com.irshad.restdemo.model.User;
import com.irshad.restdemo.service.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestServiceImplementation implements RestService {
    @Value("${restapi.regUrl}")
    private String regUrl;
    @Value("${restapi.loginUrl}")
    private String loginUrl;
    @Value("${restapi.usersUrl}")
    private String usersUrl;

    private final RestTemplate restTemplate;

    RestServiceImplementation(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public String register(User user) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(user),headers);

        HttpEntity<String> response = restTemplate.exchange(regUrl, HttpMethod.POST,request,String.class);
        return response.getBody();
    }

    @Override
    public String login(User user) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(user),headers);

        HttpEntity<String> response = restTemplate.exchange(loginUrl, HttpMethod.POST,request,String.class);
        return response.getBody();
    }

    @Override
    public String listUsers(String token) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(null,headers);
        HttpEntity<String> response = restTemplate.exchange(usersUrl, HttpMethod.GET,request,String.class);
        return response.getBody();
    }
    @Override
    public String getUser(String token,String id) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(null,headers);
        HttpEntity<String> response = restTemplate.exchange(usersUrl+"/"+id, HttpMethod.GET,request,String.class);
        return response.getBody();
    }

    @Override
    public String addUser(String token, AppUser appUser) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(appUser),headers);
        HttpEntity<String> response = restTemplate.exchange(usersUrl+"/"+appUser.getId(), HttpMethod.POST,request,String.class);
        return response.getBody();
    }

    @Override
    public String updateUser(String token, AppUser appUser) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(appUser),headers);
        HttpEntity<String> response = restTemplate.exchange(usersUrl+"/"+appUser.getId(), HttpMethod.PUT,request,String.class);
        return response.getBody();
    }

    @Override
    public String deleteUser(String token, AppUser appUser) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(appUser),headers);
        HttpEntity<String> response = restTemplate.exchange(usersUrl+"/"+appUser.getId(), HttpMethod.DELETE,request,String.class);
        return response.getBody();
    }
}
