package com.xerox78.onlinebookstore.security;

import com.xerox78.onlinebookstore.models.UserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class SecurityUtil {

    public static String getSessionUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken))
        {
            String name = authentication.getName();
            return name;
        }
        return null;
    }


    public static boolean isUserAnAdmin(UserEntity user) {
        return user.getRoles().stream().anyMatch(role -> Objects.equals(role.getName(), "ADMIN"));
    }
}
