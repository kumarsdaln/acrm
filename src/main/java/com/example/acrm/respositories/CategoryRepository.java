package com.example.acrm.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.acrm.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
