package com.firefi.backend.controller;

import com.firefi.backend.dto.CreateAccountRequest;
import com.firefi.backend.dto.LoginRequest;
import com.firefi.backend.model.User;
import com.firefi.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String createAccount(@RequestBody CreateAccountRequest request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return "Username already exists";
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return "Account created";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}
