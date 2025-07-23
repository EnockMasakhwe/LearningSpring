package com.eliarojr.spring_security_client.event.listener;

import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener
        <RegistrationCompleteEvent>{

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the verification token for the User with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();


        //Send mail to user
    }
}
