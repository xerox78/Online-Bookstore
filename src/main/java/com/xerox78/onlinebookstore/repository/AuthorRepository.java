package com.xerox78.onlinebookstore.repository;

import com.xerox78.onlinebookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
    @Query("SELECT a from Author a WHERE a.name LIKE CONCAT('%', :query, '%')")
    List<Author> searchAuthors(String query);
}
