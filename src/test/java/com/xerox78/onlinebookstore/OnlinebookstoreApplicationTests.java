package com.xerox78.onlinebookstore;

import com.xerox78.onlinebookstore.controller.AuthController;
import com.xerox78.onlinebookstore.controller.AuthorController;
import com.xerox78.onlinebookstore.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OnlinebookstoreApplicationTests {

	@Autowired
	private AuthorController authorController;
	@Autowired
	private BookController bookController;
	@Autowired
	private AuthController authController;

	@Test
	void contextLoadsAuthor() throws Exception {
		assertThat(authorController).isNotNull();
	}
	@Test
	void contextLoadsBooks() throws Exception {
		assertThat(bookController).isNotNull();
	}
	@Test
	void contextLoadsAuth() throws Exception {
		assertThat(authController).isNotNull();
	}

}
