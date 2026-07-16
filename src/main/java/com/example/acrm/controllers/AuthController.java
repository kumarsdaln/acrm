package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.acrm.dto.requests.LoginRequest;
import com.example.acrm.dto.requests.RegisterRequest;
import com.example.acrm.services.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(
        @Valid 
        @ModelAttribute("registerRequest")
        RegisterRequest request, 
        BindingResult result) {
        
            if(result.hasErrors()){
                return "auth/register";
            }
            String err = authService.register(request);
            if(err!=null){
                result.rejectValue("email", "email.exists", err);
                return "auth/register";
            }
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }
    
}
