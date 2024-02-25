package com.xerox78.onlinebookstore.dto;

import com.xerox78.onlinebookstore.models.UserEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BookDto
{
    private Long id;
    private String bookId;
    @NotEmpty(message = "Book title should not be empty")
    private String title;
    @NotEmpty(message = "Book ISBN should not be empty")
    private String isbn;
    @NotBlank(message = "Book Description should not be empty")
    private String description;
    private BigInteger price;
    private String publisher;
    private LocalDateTime publicationDate;
    private int quantityAvailable;
    private List<AuthorDto> authors;
    private UserEntity createdBy;
}
