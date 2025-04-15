package com.example.JavaBooksHub.controller;

import com.example.JavaBooksHub.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        String result = userService.registerUser(
                signupRequest.getUsername(),
                signupRequest.getEmail(),
                signupRequest.getPassword()
        );

        if (result.startsWith("Error")) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", result));
        }

        return ResponseEntity.ok(Map.of("message", result));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        if (!isAuthenticated) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password"));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }

}
