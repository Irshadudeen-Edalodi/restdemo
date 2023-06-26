package com.irshad.restdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.irshad.restdemo.model.AppUser;
import com.irshad.restdemo.model.User;

public interface RestService {
    public String register(User user) throws JsonProcessingException;
    public String login(User user) throws JsonProcessingException;
    public String listUsers(String token) throws JsonProcessingException;
    public String getUser(String token,String id) throws JsonProcessingException ;
    public String addUser(String token, AppUser appUser) throws JsonProcessingException ;
    public String updateUser(String token, AppUser appUser) throws JsonProcessingException ;
    public String deleteUser(String token, AppUser appUser) throws JsonProcessingException ;

}
