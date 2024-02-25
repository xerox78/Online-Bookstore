package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.mapper.AuthorMapper;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.repository.AuthorRepository;
import com.xerox78.onlinebookstore.repository.BookRepository;
import com.xerox78.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.xerox78.onlinebookstore.mapper.AuthorMapper.mapToAuthor;
import static com.xerox78.onlinebookstore.mapper.AuthorMapper.mapToAuthorDto;
import static com.xerox78.onlinebookstore.mapper.BookMapper.mapToBook;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(Long bookId, AuthorDto authorDto)
    {
        Book book = bookRepository.findById(bookId).get();
        Author author = mapToAuthor(authorDto);
        author.setBook(book);

        authorRepository.save(author);
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

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorRepository.deleteById(authorId);
    }


}
