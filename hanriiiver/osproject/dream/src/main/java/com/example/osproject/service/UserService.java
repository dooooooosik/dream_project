package com.example.osproject.service;

import com.example.osproject.entity.AppUser;
import com.example.osproject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String email, String password) {
    if (userRepository.existsByEmail(email)) {
        throw new IllegalArgumentException("Email already in use");
    }
    
    String encodedPassword = passwordEncoder.encode(password);
    AppUser user = new AppUser();
    user.setEmail(email);
    user.setPassword(encodedPassword);

    // 기본 username 생성
    String username = email.split("@")[0];
    user.setUsername(username);

    userRepository.save(user);
}

public boolean loginUser(String email, String password) {
    AppUser user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new IllegalArgumentException("Invalid email or password");
    }

    return true; // 인증 성공 시 true 반환
}

}
