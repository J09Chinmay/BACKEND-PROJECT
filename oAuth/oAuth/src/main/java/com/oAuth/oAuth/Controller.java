package com.oAuth.oAuth;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
public class Controller {

    @GetMapping("/login")
    public String login() {
        return "Please login using Google";
    }

    @GetMapping("/hii")
    public String hy() {
        return "Huu";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "loginSuccess";
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the oAuth application!";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal, HttpSession session) {
        // Check if user details have been printed in this session
        Boolean hasPrinted = (Boolean) session.getAttribute("hasPrinted");
        if (principal != null && (hasPrinted == null || !hasPrinted)) {
            String name = principal.getAttribute("name");
            String email = principal.getAttribute("email");
            LocalDateTime now = LocalDateTime.now();

            // Print user details and times
            System.out.println("User Name: " + name);
            System.out.println("User Email: " + email);
            System.out.println("Joined Time: " + now);
            // Set the attribute to indicate that user details have been printed
        }
        return "home";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "Login failed, please try again.";
    }
}
