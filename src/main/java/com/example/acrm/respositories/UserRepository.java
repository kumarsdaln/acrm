package com.example.acrm.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.acrm.entities.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    // if true User else null
    Optional<User> findByEmail(String email);
}
