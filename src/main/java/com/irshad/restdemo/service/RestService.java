package com.irshad.restdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.irshad.restdemo.model.User;

public interface RestService {
    public String register(User user) throws JsonProcessingException;
    public String login(User user) throws JsonProcessingException;

}
