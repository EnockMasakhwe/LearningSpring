package com.eliarojr.spring_security_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //Simple API
    @GetMapping("/hello")
    public String helloMessage(){
        return "Hello, welcome to my Security app!";
    }
}
