package com.eliarojr.user_registration_client.controller;

import com.eliarojr.user_registration_client.entity.User;
import com.eliarojr.user_registration_client.event.RegistrationCompleteEvent;
import com.eliarojr.user_registration_client.model.UserModel;
import com.eliarojr.user_registration_client.service.UserService;
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
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest httpServletRequest){
        User user = userService.registerUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(httpServletRequest)));

        return "Your registration was successful!";
    }

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" + httpServletRequest.getServerName() + ":"
                + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
    }
}
