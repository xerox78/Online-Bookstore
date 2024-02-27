package com.xerox78.onlinebookstore.service;

import com.xerox78.onlinebookstore.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    void createAuthor(Long bookId, AuthorDto authorDto);

    List<AuthorDto> findAllAuthors();

    AuthorDto findByAuthorId(Long authorId);

    void updateAuthor(AuthorDto authorDto);

    void deleteAuthor(long authorId);

    List<AuthorDto> searchAuthors(String query);
}
