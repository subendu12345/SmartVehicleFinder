package com.ravs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ravs.controller.AuthController;
import com.ravs.entities.User;
import com.ravs.repo.UserRepo;
import com.ravs.util.SessionStorage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired 
    private AuthController authController;

    @Autowired
    private UserRepo userRepo;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
        // Custom logic on successful authentication
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("request "+ request);
        System.out.println("response "+ response);
        System.out.println("authentication "+ authentication);

        HttpSession session = request.getSession();
        String user_Name = authController.getAuthUserName();
        User user = userRepo.findUserByEmail(user_Name);

        session.setAttribute("sessionObj", new SessionStorage(user.getId(), "Welcome "+user.getName()));
        if(user.getRole().equals("ADMIN")){
            response.sendRedirect("/admin");

        }else{
            response.sendRedirect("/service-provider");
        }
        
    }
}
