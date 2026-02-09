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
			bookRepository.save(new Book("kirja2", "kirjoittaja2", 2024, "54363634342", 20.00));
			bookRepository.save(new Book("kirja3", "kirjoittaja3", 1924, "5646634342", 21.00));
		};
	}

}
