package com.eliarojr.user_registration_client.service;

import com.eliarojr.user_registration_client.entity.User;
import com.eliarojr.user_registration_client.entity.VerificationToken;
import com.eliarojr.user_registration_client.model.UserModel;

import java.util.Optional;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveUserVerificationToken(User user, String token);

    String validateRegistrationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void resetPassword(User user, String newPassword);
}
