package com.example.backend.auth.controller;

import com.example.backend.auth.dto.UserDto;
import com.example.backend.config.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {
        System.out.println("qwe");
        if ("user".equals(user.getUserId()) && "pass".equals(user.getUserPwd())) {
            return jwtUtil.generateToken(user.getUserId());
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/hello")
    public String securedEndpoint() {
        return "hello world";
    }
}
