package com.eliarojr.client.service;

import com.eliarojr.client.entity.User;
import com.eliarojr.client.model.UserModel;
import com.eliarojr.client.repository.UserRepository;
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
    public User registerUser(UserModel userModel) {
        User user = new User();

        user.setEmail(user.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return user;
    }
}
