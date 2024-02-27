package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.mapper.AuthorMapper;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.repository.AuthorRepository;
import com.xerox78.onlinebookstore.repository.BookRepository;
import com.xerox78.onlinebookstore.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.xerox78.onlinebookstore.mapper.AuthorMapper.mapToAuthor;
import static com.xerox78.onlinebookstore.mapper.AuthorMapper.mapToAuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public void createAuthor(Long bookId, AuthorDto authorDto)
    {
        // Save the new author to the database
        Author author = mapToAuthor(authorDto);
        Author savedAuthor = authorRepository.save(author);

        // Retrieve the book by ID and link it to the author
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + bookId));

        // Establish the bidirectional relationship
        if (savedAuthor.getBooks() == null)
        {
            savedAuthor.setBooks(Set.of(book));
        }
        else
        {
            savedAuthor.getBooks().add(book);
        }
        book.getAuthors().add(savedAuthor);

        // Save the book to update the relationship, assuming cascading is properly configured
        // Depending on your JPA cascading settings, this might not be necessary
        bookRepository.save(book);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        return authors.stream().map(AuthorMapper::mapToAuthorDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto findByAuthorId(Long authorId) {
        Author author = authorRepository.findById(authorId).get();

        return mapToAuthorDto(author);
    }

    @Override
    public void updateAuthor(AuthorDto authorDto) {
        Author author = mapToAuthor(authorDto);

        Optional<Author> byId = authorRepository.findById(author.getId());

        author.setBooks(byId.get().getBooks());

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public List<AuthorDto> searchAuthors(String query) {
        List<Author> authors = authorRepository.searchAuthors(query);

        return authors.stream().map(AuthorMapper::mapToAuthorDto).collect(Collectors.toList());
    }


}
