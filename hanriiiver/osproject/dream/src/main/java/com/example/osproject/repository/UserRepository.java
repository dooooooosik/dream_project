package com.example.osproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.osproject.entity.AppUser; // AppUser로 변경
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> { // AppUser로 변경
    boolean existsByEmail(String email);
    Optional<AppUser> findByEmail(String email);
}

