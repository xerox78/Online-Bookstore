package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.repository.BookRepository;
import com.xerox78.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((this::mapToBookDto)).collect(Collectors.toList());
    }

    @Override
    public Book saveBook(BookDto bookDto) {
        Book book = mapToBook(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public BookDto findBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();


        return mapToBookDto(book);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Book book = mapToBook(bookDto);

        bookRepository.save(book);
    }

    @Override
    public void delete(long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> books = bookRepository.searchBooks(query);

        return books.stream().map(this::mapToBookDto).collect(Collectors.toList());
    }

    private Book mapToBook(BookDto book) {
        return Book.builder()
                .id(book.getId())
                .title(book.getTitle())
                .bookId(book.getBookId())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .publicationDate(book.getPublicationDate())
                .publisher(book.getPublisher())
                .quantityAvailable(book.getQuantityAvailable())
                .build();
    }

    private BookDto mapToBookDto(Book book)
    {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .bookId(book.getBookId())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .publicationDate(book.getPublicationDate())
                .publisher(book.getPublisher())
                .quantityAvailable(book.getQuantityAvailable())
                .build();
    }
}
