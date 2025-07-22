package com.eliarojr.job_app_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloTechCommunity(){
        return "Hello Tech Community:)";
    }
}
