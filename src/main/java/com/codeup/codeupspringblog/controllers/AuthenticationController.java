package com.codeup.codeupspringblog.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }
}
//@Controller
//public class AuthenticationController {
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        // Check if the user is already authenticated
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.isAuthenticated()) {
//            // If authenticated, redirect to the home page
//            return "redirect:/posts";
//        }
//        // If not authenticated, show the login form
//        return "users/login";
//    }
//}