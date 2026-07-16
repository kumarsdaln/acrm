package com.example.acrm.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest{
    @NotBlank(message="Name is Required")
    private String name;

    @NotBlank(message="Email is Required")
    private  String email;

    @NotBlank(message="Password is Required")
    private String Password;
}