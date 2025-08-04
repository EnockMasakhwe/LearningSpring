package com.eliarojr.spring_security_client.service;

import com.eliarojr.spring_security_client.entity.PasswordResetToken;
import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.entity.VerificationToken;
import com.eliarojr.spring_security_client.model.UserModel;
import com.eliarojr.spring_security_client.repository.PasswordResetTokenRepository;
import com.eliarojr.spring_security_client.repository.UserRepository;
import com.eliarojr.spring_security_client.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    //Implement register user method
    public User registerUser(UserModel userModel){

        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    //Implement saveVerificationTokenForUser
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);

        verificationTokenRepository.save(verificationToken);
    }

    @Override
    //Implement validateVerificationToken
    public String validateVerificationToken(String token) {

        //Find token
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);

        //Check if null
        if (verificationToken == null){
            return "Invalid token";
        }

        //Instance of user and calender
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        //Check if token has expired
        if ((verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            verificationTokenRepository.delete(verificationToken);
            return "Expired token";
        }

        //If not expired, enable user and save user details
        user.setEnabled(true);
        userRepository.save(user);
        return "Valid";
    }

    @Override
    //Implement generateNewToken for the unreceived emails
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken =  verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    //Find user by email to check if they exist in the database
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //Implement createPasswordResetToken
    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(user,token);
        passwordResetTokenRepository.save(passwordResetToken);
    }

    //Validate passwordResetToken
    @Override
    public String validatePasswordResetToken(String token) {
        //Find token
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);

        //Check if token is null
        if (passwordResetToken == null){
            return "Invalid token";
        }

        //Instances
        User user = passwordResetToken.getUser();
        Calendar calendar = Calendar.getInstance();

        //Check token expiry
        if ((passwordResetToken.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            passwordResetTokenRepository.delete(passwordResetToken);
            return "Expired token";
        }

        //If not expired, then validate it
        return "Valid";
    }

    //Print the user(s) found by passwordResetToken
    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    //Set new password
    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
