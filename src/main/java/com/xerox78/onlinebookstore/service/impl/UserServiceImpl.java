package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.RegistrationDto;
import com.xerox78.onlinebookstore.models.Role;
import com.xerox78.onlinebookstore.models.UserEntity;
import com.xerox78.onlinebookstore.repository.RoleRepository;
import com.xerox78.onlinebookstore.repository.UserRepository;
import com.xerox78.onlinebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xerox78.onlinebookstore.security.SecurityConfig.passwordEncoder;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Role role = roleRepository.findByName("USER");
        user.setRoles(List.of(role));

        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
