package hh.soft.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.soft.bookstore.domain.Book;


@Controller

public class BookController {

    @RequestMapping(value = {"/index"}, method=RequestMethod.GET)
    public String getBooks(Model model) {
        Book book = new Book("kirja", "kirjoittaja", 2026, "54363633442", 10.00);
        model.addAttribute("books", book);
        return "index";
    }
    
}
