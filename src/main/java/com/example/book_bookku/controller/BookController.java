package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.BookService;
import com.example.book_bookku.service.book_list_services.KeywordService;
import com.example.book_bookku.service.book_list_services.KeywordWithFilterService;
import com.example.book_bookku.service.book_list_services.SearchAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;
    private final KeywordService keywordService;
    private final KeywordWithFilterService keywordWithFilterService;
    private final SearchAllService searchAll;

    @Autowired
    public BookController(BookService bookService, KeywordService keywordService,
                          KeywordWithFilterService keywordWithFilterService,
                          SearchAllService searchAll){
        this.bookService = bookService;
        this.keywordService = keywordService;
        this.keywordWithFilterService = keywordWithFilterService;
        this.searchAll = searchAll;
    }

    public void setAllHandler() {
        searchAll.setNextHandler(keywordService);
        keywordService.setNextHandler(keywordWithFilterService);
    }

    private void prepareSearch(String keyword, String filterBy) {
        searchAll.setKeyword(keyword);
        searchAll.setFilterBy(filterBy);
        setAllHandler();
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable UUID id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable UUID id){
        bookService.deleteBookById(id);
        return "success";
    }

    @GetMapping("/list-filter")
    public List<Book> bookListWithFilterAndKeyword(Model model, @RequestParam("keyword") String keyword,
                                                   @RequestParam("filter-by") String filterBy) {

        prepareSearch(keyword, filterBy);

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filter-by", filterBy);
        return bookList;
    }

    @GetMapping("/list-keyword")
    public List<Book> bookListWithKeyword(Model model, @RequestParam("keyword") String keyword) {

        prepareSearch(keyword, null);

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        return bookList;
    }

    @GetMapping("/list")
    public List<Book> bookList(Model model) {

        setAllHandler();

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);

        return bookList;
    }
}