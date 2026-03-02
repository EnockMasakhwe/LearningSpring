package com.eliarojr.client.controller;

import com.eliarojr.client.entity.User;
import com.eliarojr.client.model.UserModel;
import com.eliarojr.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user = userService.registerUser(userModel);
        return "Registered Successfully!";
    }
}
