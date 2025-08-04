package com.eliarojr.spring_security_client.controller;

import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.event.RegistrationCompleteEvent;
import com.eliarojr.spring_security_client.model.UserModel;
import com.eliarojr.spring_security_client.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "Success";

    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = userService.validateVerificationToken(token);

        if (result.equalsIgnoreCase("valid")){
            return "User verified successfully.";
        }
        return "Bad user!";

    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
    }
}
