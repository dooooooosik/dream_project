package com.example.osproject.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppUser { // 이름 변경
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;
}
