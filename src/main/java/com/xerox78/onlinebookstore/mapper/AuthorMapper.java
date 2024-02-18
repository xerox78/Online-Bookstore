package com.xerox78.onlinebookstore.mapper;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.models.Author;

public class AuthorMapper {

    public static Author mapToAuthor(AuthorDto authorDto) {
        return Author.builder()
                .id(authorDto.getId())
                .name(authorDto.getName())
                .build();
    }
}
