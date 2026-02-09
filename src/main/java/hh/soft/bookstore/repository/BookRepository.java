package hh.soft.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import hh.soft.bookstore.domain.Book;

public interface BookRepository extends CrudRepository <Book, Long> {

}
