package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.acrm.dto.requests.CategoryRequest;
import com.example.acrm.respositories.CategoryRepository;
import com.example.acrm.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @GetMapping("/category")
    public String getCategory(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/index";
    }

    @GetMapping("category/create")
    public String createCategory(Model model){
        model.addAttribute("caretogyRequest", new CategoryRequest());
        return "category/create";
    }

    @PostMapping("category/store")
    public String createCategory(
        @Valid 
        @ModelAttribute("caretogyRequest")
        CategoryRequest request,
        BindingResult result){

        if(result.hasErrors()){
            return "category/create";
        }    

        categoryService.store(request);

        return "redirect:/category";
    }
}
