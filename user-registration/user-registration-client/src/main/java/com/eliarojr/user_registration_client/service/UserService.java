package com.eliarojr.user_registration_client.service;

import com.eliarojr.user_registration_client.entity.User;
import com.eliarojr.user_registration_client.model.UserModel;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveUserVerificationToken(User user, String token);

    String validateRegistrationToken(String token);
}
