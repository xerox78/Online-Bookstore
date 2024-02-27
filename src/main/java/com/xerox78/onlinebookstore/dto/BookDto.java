package com.xerox78.onlinebookstore.dto;

import com.xerox78.onlinebookstore.models.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto
{
    private Long id;
    @NotEmpty(message = "Book title should not be empty")
    private String title;
    @NotEmpty(message = "Book ISBN should not be empty")
    private String isbn;
    @NotBlank(message = "Book Description should not be empty")
    private String description;
    private BigInteger price;
    private String photoUrl;
    private String publisher;
    private LocalDateTime publicationDate;
    private int quantityAvailable;
    private Set<AuthorDto> authors = new HashSet<>();
    private UserEntity createdBy;
}
