package com.eliarojr.user_registration_client.event.listener;

import com.eliarojr.user_registration_client.entity.User;
import com.eliarojr.user_registration_client.event.RegistrationCompleteEvent;
import com.eliarojr.user_registration_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(user, token);
        //Email the user the link

    }
}
