package com.example.acrm.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.acrm.entities.User;
import com.example.acrm.respositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Start loading user..." + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> { 
                    System.out.println("User not found in DB");
                    return new UsernameNotFoundException("User not found");
                    });
        System.out.println("Found user..." + user.getName());
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isVerified())
                .authorities("ROLE_USER")
                .build();
    }
}
