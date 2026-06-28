package com.example.acrm.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequest {

    private Long id;
    
    @NotBlank(message="Name is required")
    private String name;
}
