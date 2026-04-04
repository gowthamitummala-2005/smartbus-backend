package com.example.smartbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public Map<String, Object> register(@RequestParam String username,
                                        @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();

        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            response.put("success", false);
            response.put("message", "User already exists");
            return response;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        response.put("success", true);
        response.put("message", "Registered successfully");
        return response;
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();

        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }

        return response;
    }
}