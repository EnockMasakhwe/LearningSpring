package com.eliarojr.user_registration_client.controller;

import com.eliarojr.user_registration_client.entity.User;
import com.eliarojr.user_registration_client.entity.VerificationToken;
import com.eliarojr.user_registration_client.event.RegistrationCompleteEvent;
import com.eliarojr.user_registration_client.model.UserModel;
import com.eliarojr.user_registration_client.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
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

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token")String token){
        String result = userService.validateRegistrationToken(token);
        if (result.equalsIgnoreCase("valid")){
            return "User verified successfully!";
        }
        return "Invalid user verification details!";
    }

    @GetMapping("/resendVerificationToken")
    public String resendVerificationToken(@RequestParam("token")String oldToken, HttpServletRequest httpServletRequest){
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);

        User user = verificationToken.getUser();
        resendVerificationTokenMail(user, applicationUrl(httpServletRequest), verificationToken);
        return "Verification link resent successfully!";
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
        //Email the user the link
        String url = applicationUrl + "/verifyRegistration?token=" + verificationToken.getToken();
        log.info("Click the link to verify your account: {}",url);
    }

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" + httpServletRequest.getServerName() + ":"
                + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
    }

}
