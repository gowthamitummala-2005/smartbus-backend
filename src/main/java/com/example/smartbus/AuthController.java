package com.example.smartbus;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER
    @GetMapping("/register")
    public Map<String, Object> register(
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, Object> res = new HashMap<>();

        if (userRepository.findByUsername(username) != null) {
            res.put("success", false);
            res.put("message", "User already exists");
            return res;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        res.put("success", true);
        res.put("message", "Registered successfully");
        return res;
    }

    // LOGIN
    @GetMapping("/login")
    public Map<String, Object> login(
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();

        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null &&
                existingUser.getPassword().equals(password)) {
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }

        return response;
    }
}