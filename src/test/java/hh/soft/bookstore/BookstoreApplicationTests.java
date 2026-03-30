package hh.soft.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.soft.bookstore.web.BookController;
import hh.soft.bookstore.web.BookRestController;
import hh.soft.bookstore.web.CategoryController;

@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private BookRestController bookRestController;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(bookRestController).isNotNull();
	}

}
