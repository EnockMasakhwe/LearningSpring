package com.eliarojr.spring_security_client.service;

import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.entity.VerificationToken;
import com.eliarojr.spring_security_client.model.UserModel;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);
}
