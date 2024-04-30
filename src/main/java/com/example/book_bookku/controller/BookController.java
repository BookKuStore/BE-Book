package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import com.example.book_bookku.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    @Autowired
//    public BookController(BookService bookService){
//        this.bookService = bookService;
//    }

//    @GetMapping("/list")
//    public List<Book> getBooks(){
//        return bookService.getBooks("Tolkien");
//    }
//    @GetMapping("/list")
//    public String bookListPage(Model model, @Param("keyword") String keyword) {
//        List<Book> bookList = bookService.getBooks(keyword);
//        model.addAttribute("bookList", bookList);
//        model.addAttribute("keyword", keyword);
//        return "books/booklist";
//    }
    @GetMapping("/list")
    public String bookListPage(Model model, @RequestParam("keyword") String keyword, @RequestParam("filter-by") String filterBy) {
        List<Book> bookList = bookService.getBooks(keyword, filterBy);
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filter-by", filterBy);
        return "books/booklist";
    }
//    @GetMapping("/list")
//    public List<Book> findAll() {
//        return bookService.findAll();
//    }
}
