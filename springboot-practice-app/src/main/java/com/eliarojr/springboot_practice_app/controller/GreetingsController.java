package com.eliarojr.springboot_practice_app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String Greetings(){
        return welcomeMessage;
    }
}
