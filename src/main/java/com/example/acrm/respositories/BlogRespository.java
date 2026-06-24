package com.example.acrm.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.acrm.entities.Blog;

public interface BlogRespository extends JpaRepository<Blog, Long> {
    
}
