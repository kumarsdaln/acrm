package com.example.acrm.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.acrm.entities.Category;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    boolean existsByName(String Name);
}
