package com.ravs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ravs.entities.User;
import com.ravs.repo.UserRepo;

@Service
public class AuthService {

    @Autowired
    private UserRepo  userRepo;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    //sign-up service
    public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    //login service
    public User login(String username, String password) {
        User user = userRepo.findByEmail(username).orElseThrow();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
    
}
