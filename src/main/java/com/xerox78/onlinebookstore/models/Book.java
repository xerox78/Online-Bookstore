package com.xerox78.onlinebookstore.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookId;
    private String title;
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Author> authors = new ArrayList<>();
    private String isbn;
    private String description;
    private BigInteger price;
    private String publisher;
    private LocalDateTime publicationDate;
    private int quantityAvailable;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;
}
