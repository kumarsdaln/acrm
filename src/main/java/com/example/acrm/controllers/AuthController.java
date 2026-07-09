package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.example.acrm.dto.requests.RegisterRequest;
import com.example.acrm.services.AuthService;


@Controller
public class AuthController {
    private final AuthService authService;
    @GetMapping("/auth/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest())
        return "auth/register";
    }

    @PostMapping("/auth/register")
    public String register(
        @Valid 
        @ModelAttribute("registerRequest")
        RegisterRequest request, 
        BindingResult result) {
        
            if(result.hasErrors()){
                return 'auth/register';
            }
            String err = authService.register(request);
            if(err!=null){
                result.rejectValue("email", "email.exists", err);
                return 'auth/register';
            }
        return "redirect:login";
    }
    
}
