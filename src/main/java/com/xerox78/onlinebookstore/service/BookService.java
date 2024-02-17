package com.xerox78.onlinebookstore.service;

import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();

    Book saveBook(BookDto book);

    BookDto findBookById(long bookId);

    void updateBook(BookDto bookDto);

    void delete(long bookId);

    List<BookDto> searchBooks(String query);
}
