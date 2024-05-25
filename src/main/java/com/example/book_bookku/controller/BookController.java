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

import java.util.*;
import java.util.concurrent.CompletableFuture;

@CrossOrigin
@RestController
@RequestMapping(path = "book")
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

    private void prepareSearch(String keyword, String filterBy, String sortBy, String sortDir) {
        searchAll.setKeyword(keyword);
        searchAll.setFilterBy(filterBy);
        searchAll.setSortBy(sortBy);
        searchAll.setSortDir(sortDir);

        setAllHandler();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        Map<String, Object> response = new HashMap<>();
        ResponseEntity responseEntity = null;

        try {
            List<Book> books = bookService.getAllBooks();

            response.put("status", HttpStatus.OK);
            response.put("message", "Success");
            response.put("data", books);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            System.out.println("Error in get all books!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id){
        Map<String, Object> response = new HashMap<>();
        ResponseEntity responseEntity = null;

        try {
            Optional<Book> book = bookService.getBookById(id);

            response.put("status", HttpStatus.OK);
            response.put("message", "Success");
            response.put("data", book);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            System.out.println("Error in getting book!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
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

    @PostMapping("/{id}")
    public String updateBook(@PathVariable UUID id, @RequestBody Book book){
        Book newBook = bookService.editBook(id, book);
        return "success";
    }

    @GetMapping("/list")
    public List<Book> bookListBy(Model model,
                                 @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(name = "filter-by", required = false, defaultValue = "") String filterBy,
                                 @RequestParam(name = "sort-by", required = false, defaultValue = "judul") String sortBy,
                                 @RequestParam(name = "sort-dir", required = false, defaultValue = "asc") String sortDir) {

        prepareSearch(keyword, filterBy, sortBy, sortDir);

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filter-by", filterBy);
        model.addAttribute("sort-by", sortBy);
        model.addAttribute("sort-dir", sortDir);

        return bookList;
    }
}
