package hh.soft.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import hh.soft.bookstore.domain.Book;
import hh.soft.bookstore.repository.BookRepository;
import hh.soft.bookstore.domain.Category;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitleContainingIgnoreCase("Fellowship");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.R.R. Tolkien");
    }

    @Test
    public  void createNewBook() {
        Category category4 = new Category("Horror");
        Book book = new Book("Bird Box", "Josh Malerman", 2014, "9780062259664", 15.99, category4);
        repository.save(book);
        assertThat(book.getBookId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Category category4 = new Category("Horror");
        Book book = new Book("Bird Box", "Josh Malerman", 2014, "9780062259664", 15.99, category4);
        repository.save(book);
        assertThat(book.getBookId()).isNotNull();

        repository.delete(book);
        assertThat(repository.findById(book.getBookId()).isEmpty());
    }

}
