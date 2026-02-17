package com.eliarojr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greetings(){
        return "Hello there, long time no see but I'm so glad to be back:)";
    }
}
