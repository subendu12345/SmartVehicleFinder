// This is the service class for User entity. It has a method userRegistration() which takes User object as input and saves it in the database using UserRepo object.
package com.ravs.services;

import com.ravs.entities.User;


public interface UserService {

    User createUser(User user);
    User getUserByEmail(String email);
    User updateUser(User user);
    boolean deleteUserByEmail(String email);
} 


    // public void userRegistration(User user){
    //     userRepo.save(user);
    // }
    

