package com.xerox78.onlinebookstore.service.impl;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.repository.AuthorRepository;
import com.xerox78.onlinebookstore.repository.BookRepository;
import com.xerox78.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xerox78.onlinebookstore.mapper.AuthorMapper.mapToAuthor;

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

}
