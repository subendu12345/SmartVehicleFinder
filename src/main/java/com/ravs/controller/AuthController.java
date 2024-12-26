package com.ravs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravs.entities.User;
import com.ravs.services.AuthService;
import com.ravs.wrapper.LoginWrapper;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    //sign-up service
    @PostMapping("/signup")
    public User signUp(@ModelAttribute("user") User user) {
        user.setRole("ROLE_USER");
        System.out.println("hello I am from signup----------" + user.toString());

        return authService.signUp(user);
    }

    //login service login
    @PostMapping("/login")
    public User login(@ModelAttribute("login") LoginWrapper loginWrapper) {
        System.out.println("hello I am from login----------");
        return authService.login(loginWrapper.getEmail(), loginWrapper.getPassword());
    }

    public boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("====> "+authentication.getName());
        return authentication != null && authentication.isAuthenticated();
    }

    public String getAuthUserName(){
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    
    
}
