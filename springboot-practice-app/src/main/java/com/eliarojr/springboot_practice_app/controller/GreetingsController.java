package com.eliarojr.springboot_practice_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String Greetings(){
        return "Hey techies, am just having fun with Springboot:)";
    }
}
