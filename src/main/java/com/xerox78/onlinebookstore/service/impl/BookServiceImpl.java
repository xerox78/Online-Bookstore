package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.mapper.BookMapper;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.models.UserEntity;
import com.xerox78.onlinebookstore.repository.BookRepository;
import com.xerox78.onlinebookstore.repository.UserRepository;
import com.xerox78.onlinebookstore.security.SecurityUtil;
import com.xerox78.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.xerox78.onlinebookstore.mapper.BookMapper.mapToBook;
import static com.xerox78.onlinebookstore.mapper.BookMapper.mapToBookDto;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((BookMapper::mapToBookDto)).collect(Collectors.toList());
    }

    @Override
    public Book saveBook(BookDto bookDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Book book = mapToBook(bookDto);
        book.setCreatedBy(user);
        return bookRepository.save(book);
    }

    @Override
    public BookDto findBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return mapToBookDto(book);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Book book = mapToBook(bookDto);
        book.setCreatedBy(user);
        bookRepository.save(book);
    }

    @Override
    public void delete(long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> books = bookRepository.searchBooks(query);

        return books.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findBooksByAuthorId(Long authorId) {
        List<Book> booksByAuthorId = bookRepository.findBooksByAuthorId(authorId);

        return booksByAuthorId.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());
    }


}
