package com.example.acrm.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message="Name is required")
    @Size(min=2, max=200, message="Name must be between 2 and 200 characters")
    private String name;
    
    @NotBlank(message="Name is required")
    @Size(min=2, max=200, message="Email must be between 2 and 200 characters")
    @Email(message="Invalid Email")
    private String email;

    @NotBlank(message="Name is required")
    @Size(min=8, max=30, message="Password must be between 8 and 30 characters")
    private String password;
}
