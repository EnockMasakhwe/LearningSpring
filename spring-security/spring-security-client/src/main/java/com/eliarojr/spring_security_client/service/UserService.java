package com.eliarojr.spring_security_client.service;

import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.entity.VerificationToken;
import com.eliarojr.spring_security_client.model.UserModel;

import java.util.Optional;

public interface UserService {
    public User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);
}
