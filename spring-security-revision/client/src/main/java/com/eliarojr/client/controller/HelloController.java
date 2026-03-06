package com.eliarojr.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(Principal principal){
        return "Hello" + principal.getName() + ", Welcome to my SpringBoot App!";
    }
}

