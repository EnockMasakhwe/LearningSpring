package com.eliarojr.simple_api_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello Techies, we go again this this week.";
    }
}
