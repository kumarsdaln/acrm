package com.example.acrm.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.acrm.dto.requests.RegisterRequest;


public class AuthController{
    @GetMapping
    public String register(Model model){
        model.addAttribute('registerRequest', new RegisterRequest())
        return "auth/register";
    }

    @GetMapping
    public String login(){
        return "auth/register";
    }
}