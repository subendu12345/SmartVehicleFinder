// This is the controller class for the home page, service provider page and sign-up page.
package com.ravs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ravs.wrapper.LoginWrapper;
import com.ravs.entities.User;

@Controller
public class HomeController {
    
    //handle home request
    @RequestMapping("/")
    public String sendHomePage(Model model){
        model.addAttribute("title", "home");
        return "home";
    }

    //handle service provider request
    @RequestMapping("/service-provider")
    public String sendServiceProvider(Model model){
        model.addAttribute("title", "servise provider");
        return "/serviceProvider/serviceProvider";
    }

    //handle sign-up request
    @RequestMapping("/signup")
    public String sendS(Model model){
        model.addAttribute("title", "Signup");
        model.addAttribute("user", new User() );
        return "/serviceProvider/signup";
    }

    @RequestMapping("/signin")
    public String sendLogin(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute("login", new LoginWrapper());
        return "login";
    }


}
