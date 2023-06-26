package com.irshad.restdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.irshad.restdemo.model.AppUser;
import com.irshad.restdemo.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            String response = restServiceImplementation.register(user);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

    @PostMapping("/userLogin")
    public ResponseEntity<String> userLogin(@RequestBody User user){
        log.info("Received login request :"+ user);

        try {
            String response = restServiceImplementation.login(user);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }
    @GetMapping("/getUserList")
    public ResponseEntity<String> listUsers(@RequestHeader("Authorization") String bearerToken){
        log.info("Received request to list users");

        try {
            String response = restServiceImplementation.listUsers(bearerToken.split(" ")[1]);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUser(@RequestHeader("Authorization") String bearerToken,@PathVariable("id") String id){
        log.info("Received request to get user with Id {}",id);

        try {
            String response = restServiceImplementation.getUser(bearerToken.split(" ")[1],id);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }
    @PostMapping("/user/{id}")
    public ResponseEntity<String> addUser(@RequestHeader("Authorization") String bearerToken,@PathVariable("id") String id,
                                          @RequestBody AppUser appUser){
        log.info("Received request to add appUser {}",appUser);

        try {
            String response = restServiceImplementation.addUser(bearerToken.split(" ")[1],appUser);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@RequestHeader("Authorization") String bearerToken,@PathVariable("id") String id,
                                          @RequestBody AppUser appUser){
        log.info("Received request to update appUser {}",appUser);

        try {
            String response = restServiceImplementation.updateUser(bearerToken.split(" ")[1],appUser);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@RequestHeader("Authorization") String bearerToken,@PathVariable("id") String id,
                                             @RequestBody AppUser appUser){
        log.info("Received request to delete appUser {}",appUser);

        try {
            String response = restServiceImplementation.deleteUser(bearerToken.split(" ")[1],appUser);
            log.info("Response :"+ response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("Error processing request");
        }

    }

}
