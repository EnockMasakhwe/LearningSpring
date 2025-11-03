package com.eliarojr.user_registration_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloMessage(){
        return "Hey there, welcome to my secured springboot application!";
    }
}
