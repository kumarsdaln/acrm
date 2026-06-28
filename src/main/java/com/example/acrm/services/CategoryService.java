package com.example.acrm.services;

import org.springframework.stereotype.Service;

import com.example.acrm.dto.requests.CategoryRequest;
import com.example.acrm.entities.Category;
import com.example.acrm.respositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService{

    private final CategoryRepository categoryRepositoty;

    public String store(CategoryRequest request){
        if(categoryRepositoty.existsByName(request.getName())){
            return "Category Already Exists";
        }
        Category category = Category.builder()
                                    .name(request.getName())
                                    .build();
        categoryRepositoty.save(category);
        return null;                         
    }

    public Category update(CategoryRequest request){
        Category category = categoryRepositoty.findById(request.getId())
                            .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(request.getName());
        return categoryRepositoty.save(category);                         
    }

    public boolean delete(Long id){
        if(!categoryRepositoty.existsById(id)){
            return false;
        }
        categoryRepositoty.deleteById(id);
        return true;
    }
}