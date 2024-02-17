package com.xerox78.onlinebookstore.service;

import com.xerox78.onlinebookstore.dto.AuthorDto;

public interface AuthorService {
    void createAuthor(Long bookId, AuthorDto eventDto);
}
