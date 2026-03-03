package com.eliarojr.client.service;

import com.eliarojr.client.entity.User;
import com.eliarojr.client.entity.VerificationToken;
import com.eliarojr.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationToken(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);
}
