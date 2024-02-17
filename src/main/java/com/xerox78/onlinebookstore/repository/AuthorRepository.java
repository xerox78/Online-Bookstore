package com.xerox78.onlinebookstore.repository;

import com.xerox78.onlinebookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
}
