package com.xerox78.onlinebookstore.controller;

import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Author;
import com.xerox78.onlinebookstore.models.UserEntity;
import com.xerox78.onlinebookstore.security.SecurityUtil;
import com.xerox78.onlinebookstore.service.AuthorService;
import com.xerox78.onlinebookstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    private UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            userEntity = userService.findByUsername(username);
        }
        return userEntity;
    }

    @GetMapping("/authors")
    public String authorsList(Model model) {
        UserEntity user = getUserEntity();
        List<AuthorDto> authors = authorService.findAllAuthors();

        model.addAttribute("authors", authors);
        model.addAttribute("user", user);
        return "authors-list";
    }

    @GetMapping("/authors/{authorId}")
    public String viewAuthor(@PathVariable("authorId") Long authorId, Model model) {
        UserEntity user = getUserEntity();

        AuthorDto authorDto = authorService.findByAuthorId(authorId);
        model.addAttribute("author", authorDto);
        model.addAttribute("user", user);

        return "authors-detail";
    }

    @GetMapping("/authors/{bookId}/new")
    public String createAuthorForm(@PathVariable("bookId") Long bookId, Model model) {
        Author author = new Author();
        model.addAttribute("bookId", bookId);
        model.addAttribute("author", author);

        return "authors-create";
    }

    @PostMapping("/authors/{bookId}")
    public String createAuthor(@PathVariable("bookId") Long bookId, @ModelAttribute("author") AuthorDto authorDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("author", authorDto);
            return "books-create";
        }

        authorService.createAuthor(bookId, authorDto);
        return "redirect:/books/" + bookId;
    }


    @GetMapping("/authors/{authorId}/edit")
    public String editAuthorForm(@PathVariable("authorId") long authorId, Model model) {
        AuthorDto authorDto = authorService.findByAuthorId(authorId);
        model.addAttribute("author", authorDto);
        return "authors-edit";
    }

    @PostMapping("/authors/{authorId}/edit")
    public String updateAuthor(@PathVariable("authorId") long authorId,
                               @Valid @ModelAttribute("author") AuthorDto authorDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("author", authorDto);
            return "authors-edit";
        }
        AuthorDto author = authorService.findByAuthorId(authorId);
        authorDto.setId(authorId);
        authorDto.setBook(author.getBook());
        authorService.updateAuthor(authorDto);

        return "redirect:/authors";
    }

    @GetMapping("/authors/{authorId}/delete")
    public String deleteAuthor(@PathVariable("authorId") long authorId) {
        authorService.deleteAuthor(authorId);
        return "redirect:/authors";
    }
}
