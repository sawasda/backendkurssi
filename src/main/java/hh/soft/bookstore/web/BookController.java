package hh.soft.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.soft.bookstore.domain.Book;
import hh.soft.bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
    
}
