package com.xerox78.onlinebookstore.repository;

import com.xerox78.onlinebookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b from Book b WHERE b.title LIKE CONCAT('%', :query, '%')")
    List<Book> searchBooks(String query);

    @Query("SELECT b FROM Book b INNER JOIN b.authors a WHERE a.id = :authorId")
    List<Book> findBooksByAuthorId(Long authorId);
}
