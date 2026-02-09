package hh.soft.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.soft.bookstore.domain.Book;
import hh.soft.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("A Brief History of Time", "Stephen Hawking", 1988, "9780553380163", 17.95));
        	bookRepository.save(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, "9780547928210", 22.95));
        	bookRepository.save(new Book("A Game of Thrones", "George R.R. Martin", 1996, "9780553593716", 25.00));
		};
	}

}
