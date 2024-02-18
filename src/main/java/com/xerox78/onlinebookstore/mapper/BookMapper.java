package com.xerox78.onlinebookstore.mapper;

import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Book;

public class BookMapper {

    public static Book mapToBook(BookDto book) {
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

    public static BookDto mapToBookDto(Book book)
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
