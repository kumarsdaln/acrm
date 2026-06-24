package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.acrm.respositories.BlogRespository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogRespository blogRespository;

    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("blog", blogRespository.findAll());
        return "blog/index";
    }

    @GetMapping("/blog/create")
    public String createBlog() {
        return "blog/create";
    }

    @PostMapping("/blog/store")
    public String storeBlog() {
        return "";
    }

    @GetMapping("/blog/edit")
    public String editBlog() {
        return "blog/edit";
    }

    @PostMapping("/blog/update")
    public String updateBlog() {
        return "";
    }

    @PostMapping("/blog/delete")
    public String deleteBlog() {
        return "";
    } 
}
