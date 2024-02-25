package com.xerox78.onlinebookstore.service;

import com.xerox78.onlinebookstore.dto.RegistrationDto;
import com.xerox78.onlinebookstore.models.UserEntity;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
