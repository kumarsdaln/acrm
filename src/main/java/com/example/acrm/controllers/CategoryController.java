package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.acrm.dto.requests.CategoryRequest;
import com.example.acrm.entities.Category;
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

        String err = categoryService.store(request);
        if(err!=null){
            result.rejectValue("name", "errors.name", err);
            return "category/create";
        }

        return "redirect:/category";
    }


    @GetMapping("category/{id}/edit")
    public String updateCategory(@PathVariable Long id, Model model){
        Category category = categoryRepository.findById(id)
                           .orElseThrow(() -> new RuntimeException("Category not found"));
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setId(category.getId());
        categoryRequest.setName(category.getName());
        model.addAttribute("categoryRequest", categoryRequest);
        return "category/edit";
    }

    @PostMapping("category/update")
    public String updateCategory(
        @Valid
        @ModelAttribute("caretogyRequest")
        CategoryRequest request, 
        BindingResult result)
    {
        if(result.hasErrors()){
            return "category/edit";
        }  
        categoryService.update(request);
        return "redirect:/category";
    }

    @GetMapping("/category/{id}/delete")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
    
}
