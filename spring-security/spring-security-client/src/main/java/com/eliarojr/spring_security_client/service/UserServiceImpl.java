package com.eliarojr.spring_security_client.service;

import com.eliarojr.spring_security_client.entity.User;
import com.eliarojr.spring_security_client.model.UserModel;
import com.eliarojr.spring_security_client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel){

        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }
}
