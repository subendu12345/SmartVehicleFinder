// This is the service class for User entity. It has a method userRegistration() which takes User object as input and saves it in the database using UserRepo object.
package com.ravs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravs.entities.User;
import com.ravs.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public void userRegistration(User user){
        userRepo.save(user);
    }
    
}
