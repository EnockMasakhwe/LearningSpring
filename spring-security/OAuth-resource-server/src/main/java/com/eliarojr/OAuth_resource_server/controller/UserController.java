package com.eliarojr.OAuth_resource_server.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public String [] getUser(){
        return new String[]{"Enock","Ian","Benard"};
    }
}
