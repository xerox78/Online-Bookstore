package com.xerox78.onlinebookstore.mapper;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.models.Book;

import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {

    public static Book mapToBook(BookDto book) {
        Set<Author> author = null;
        if (book.getAuthors() != null && !book.getAuthors().isEmpty())
        {
            author = book.getAuthors().stream().map(AuthorMapper::mapToAuthor).collect(Collectors.toSet());
        }

        return Book.builder()
                .id(book.getId())
                .title(book.getTitle())
                .photoUrl(book.getPhotoUrl())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .publicationDate(book.getPublicationDate())
                .publisher(book.getPublisher())
                .quantityAvailable(book.getQuantityAvailable())
                .createdBy(book.getCreatedBy())
                .authors(author)
                .build();
    }

    public static BookDto mapToBookDto(Book book)
    {
        Set<AuthorDto> authorDto = null;
        if (book.getAuthors() != null && !book.getAuthors().isEmpty())
        {
            authorDto = book.getAuthors().stream().map(AuthorMapper::mapToAuthorDto).collect(Collectors.toSet());
        }
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .photoUrl(book.getPhotoUrl())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .publicationDate(book.getPublicationDate())
                .publisher(book.getPublisher())
                .quantityAvailable(book.getQuantityAvailable())
                .authors(authorDto)
                .createdBy(book.getCreatedBy())
                .build();
    }
}
