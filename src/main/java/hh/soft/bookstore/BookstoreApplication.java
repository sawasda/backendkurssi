package hh.soft.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.soft.bookstore.domain.Book;
import hh.soft.bookstore.domain.Category;
import hh.soft.bookstore.repository.BookRepository;
import hh.soft.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Science");
			categoryRepository.save(category1);
			Category category2 = new Category("Fantasy");
			categoryRepository.save(category2);
			Category category3 = new Category("Sci-fi");
			categoryRepository.save(category3);

			bookRepository.save(new Book("A Brief History of Time", "Stephen Hawking", 1988, "9780553380163", 17.95, category1));
        	bookRepository.save(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, "9780547928210", 22.95, category2));
        	bookRepository.save(new Book("A Game of Thrones", "George R.R. Martin", 1996, "9780553593716", 25.00, category2));
		};
	}
}
