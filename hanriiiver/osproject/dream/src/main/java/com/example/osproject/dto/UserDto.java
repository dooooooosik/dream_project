package com.example.osproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotBlank(message = "Email cannot be blank") // null 및 공백 문자열까지 검증
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank") // null 및 공백 문자열까지 검증
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // 선택적으로 username 필드를 추가
    @Size(max = 50, message = "Username must be less than 50 characters") // 최대 길이 제한
    private String username;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
