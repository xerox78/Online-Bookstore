package com.xerox78.onlinebookstore;

import com.xerox78.onlinebookstore.controller.AuthorController;
import com.xerox78.onlinebookstore.dto.AuthorDto;
import com.xerox78.onlinebookstore.dto.BookDto;
import com.xerox78.onlinebookstore.service.AuthorService;
import com.xerox78.onlinebookstore.service.BookService;
import com.xerox78.onlinebookstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
@AutoConfigureMockMvc
public class AuthorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private BookService bookService;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "test", roles = {"ADMIN"})
    void authorsListReturnAuthors() throws Exception {
        when(authorService.findAllAuthors()).thenReturn(List.of(new AuthorDto()));

        this.mockMvc
                .perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors-list"));
    }
    @Test
    @WithMockUser(username = "test", roles = {"ADMIN"})
    void viewAuthorReturnsAuthorWithBooks() throws Exception {
        when(authorService.findByAuthorId(1L)).thenReturn(new AuthorDto());
        when(bookService.findBooksByAuthorId(1L)).thenReturn(List.of(new BookDto()));

        this.mockMvc
                .perform(get("/authors/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors-detail"))
                .andExpect(model().attribute("author", new AuthorDto()))
                .andExpect(model().attribute("books", List.of(new BookDto())));
    }
}
