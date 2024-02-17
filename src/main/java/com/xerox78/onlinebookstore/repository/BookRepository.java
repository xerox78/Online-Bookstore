package com.xerox78.onlinebookstore.repository;

import com.xerox78.onlinebookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    @Query("SELECT b from Book b WHERE b.title LIKE CONCAT('%', :query, '%')")
    List<Book> searchBooks(String query);
}
