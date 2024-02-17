package com.xerox78.onlinebookstore.dto;

import com.xerox78.onlinebookstore.models.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private long id;
    private String name;
    private Book book;
}
