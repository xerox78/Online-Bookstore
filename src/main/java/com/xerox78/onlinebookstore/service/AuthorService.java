package com.xerox78.onlinebookstore.service;

import com.xerox78.onlinebookstore.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    void createAuthor(Long bookId, AuthorDto eventDto);

    List<AuthorDto> findAllAuthors();

    AuthorDto findByAuthorId(Long authorId);
}
