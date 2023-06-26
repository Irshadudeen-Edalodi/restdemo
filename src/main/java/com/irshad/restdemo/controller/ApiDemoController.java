package com.irshad.restdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.irshad.restdemo.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.irshad.restdemo.service.impl.RestServiceImplementation;

@RestController
@RequestMapping("/restdemo")
@AllArgsConstructor
@Slf4j
public class ApiDemoController {
    RestServiceImplementation restServiceImplementation;
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        log.info("Received registration request :"+ user);

        try {
            return ResponseEntity.ok(restServiceImplementation.register(user));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

}
