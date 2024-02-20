package com.xerox78.onlinebookstore.controller;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String authorsList(Model model)
    {
        List<AuthorDto> authors = authorService.findAllAuthors();

        model.addAttribute("authors", authors);
        return "authors-list";
    }
    @GetMapping("/authors/{authorId}")
    public String viewAuthor(@PathVariable("authorId") Long authorId, Model model)
    {
       AuthorDto authorDto = authorService.findByAuthorId(authorId);
       model.addAttribute("author", authorDto);
       return "authors-detail";
    }

    @GetMapping("/authors/{bookId}/new")
    public String createAuthorForm(@PathVariable("bookId") Long bookId, Model model)
    {
        Author author = new Author();
        model.addAttribute("bookId", bookId);
        model.addAttribute("author", author);

        return "authors-create";
    }

    @PostMapping("/authors/{bookId}")
    public String createAuthor(@PathVariable("bookId") Long bookId, @ModelAttribute("author") AuthorDto authorDto, Model model)
    {
        authorService.createAuthor(bookId, authorDto);

        return "redirect:/books/" + bookId;
    }
}
