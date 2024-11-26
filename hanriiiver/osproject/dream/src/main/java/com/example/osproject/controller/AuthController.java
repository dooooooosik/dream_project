package com.example.osproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.osproject.dto.UserDto;
import com.example.osproject.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // GET 요청에 대한 처리
    @GetMapping("/register")
    public ResponseEntity<String> handleBrowserRequest() {
        return ResponseEntity.badRequest().body("GET method is not supported for this endpoint. Use POST instead.");
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.registerUser(userDto.getEmail(), userDto.getPassword());
            return ResponseEntity.ok("Registration successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.loginUser(userDto.getEmail(), userDto.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
