package hh.soft.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.soft.bookstore.repository.BookRepository;
import hh.soft.bookstore.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
@RequestMapping("/rest")

public class BookRestController {

    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest() {
        return  (List<Book>) bookRepository.findAll();
    }
    
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping(value="/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {        
        return bookRepository.save(book);
    }
    
}
