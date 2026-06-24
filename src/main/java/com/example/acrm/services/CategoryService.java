package com.example.acrm.services;

import com.example.acrm.dto.requests.CategoryRequest;
import com.example.acrm.entities.Category;
import com.example.acrm.respositories.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService{

    private final CategoryRepository categoryRepositoty;

    public Category store(CategoryRequest request){
        Category category = Category.builder()
                                    .name(request.getName())
                                    .build();
        return categoryRepositoty.save(category);                         
    }
}