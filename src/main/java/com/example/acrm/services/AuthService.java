package com.example.acrm.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.acrm.dto.requests.RegisterRequest;
import com.example.acrm.respositories.UserRepository;
import lombok.RequiredArgsConstructor;

import com.example.acrm.entities.User;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            return "This Email Alredy Exists";
        }

        User user = User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build();
        userRepository.save(user);
        return null;              
    }
}
