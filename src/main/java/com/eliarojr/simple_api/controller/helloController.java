package com.eliarojr.simple_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hey there, just checking up on you:)";
    }
}
