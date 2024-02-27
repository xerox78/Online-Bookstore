package com.xerox78.onlinebookstore.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude="books")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String photoUrl;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
