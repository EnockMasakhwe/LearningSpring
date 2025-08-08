package com.eliarojr.spring_security_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    //Simple API
    @GetMapping("/api/hello")
    public String helloMessage(Principal principal){
        return "Hello " + principal.getName() + ", welcome to my Security app!";
    }
}
