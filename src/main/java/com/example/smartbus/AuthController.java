package com.example.smartbus;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();

        if (userRepository.findByUsername(user.getUsername()) != null) {
            res.put("success", false);
            res.put("message", "User already exists");
            return res;
        }

        userRepository.save(user);
        res.put("success", true);
        res.put("message", "Registered successfully");
        return res;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null &&
                existingUser.getPassword().equals(user.getPassword())) {
            res.put("success", true);
            res.put("message", "Login successful");
        } else {
            res.put("success", false);
            res.put("message", "Invalid credentials");
        }

        return res;
    }
}