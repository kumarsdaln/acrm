package com.example.acrm.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.acrm.entities.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    // if true User else null
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
