package com.xerox78.onlinebookstore.controller;

import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.models.Book;
import com.xerox78.onlinebookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String listBooks(Model model)
    {
        List<BookDto> allBooks = bookService.findAllBooks();
        System.out.println(allBooks);
        model.addAttribute("books", allBooks);

        return "books-list";
    }

    @GetMapping("/books/{bookId}")
    public String bookDetail(@PathVariable("bookId") long bookId, Model model)
    {
        BookDto bookDto = bookService.findBookById(bookId);
        model.addAttribute("book", bookDto);

        return "books-detail";
    }

    @GetMapping("/books/form")
    public String createBookForm(Model model)
    {
        Book book = new Book();
        model.addAttribute("book", book);
        return "books-create";
    }

    @PostMapping("/books/new")
    public String saveBooks(@Valid @ModelAttribute("book") BookDto book, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("book", book);
            return "books-create";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/edit")
    public String editBookForm(@PathVariable("bookId") long bookId, Model model)
    {
        BookDto book = bookService.findBookById(bookId);
        model.addAttribute("book", book);
        return "books-edit";
    }

    @PostMapping("/books/{bookId}/edit")
    public String updateBook(@PathVariable("bookId") long bookId,
                             @Valid @ModelAttribute("book") BookDto bookDto,
                            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "books-edit";
        }
        bookDto.setId(bookId);
        bookService.updateBook(bookDto);

        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/delete")
    public String deleteBook(@PathVariable("bookId") long bookId)
    {
        bookService.delete(bookId);
        return "redirect:/books";
    }

    @GetMapping("/books/search")
    public String searchBook(@RequestParam(value = "query") String query, Model model)
    {
        List<BookDto> booksDto = bookService.searchBooks(query);
        model.addAttribute("books", booksDto);
        return "books-list";
    }

}
