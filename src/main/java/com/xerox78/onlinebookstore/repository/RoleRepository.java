package com.xerox78.onlinebookstore.repository;

import com.xerox78.onlinebookstore.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
