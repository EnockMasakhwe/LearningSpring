package com.eliarojr.client.controller;

import com.eliarojr.client.entity.User;
import com.eliarojr.client.event.RegistrationCompleteEvent;
import com.eliarojr.client.model.UserModel;
import com.eliarojr.client.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel );
        eventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Registered Successfully!";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
