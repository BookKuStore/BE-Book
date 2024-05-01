package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.KeywordService;
import com.example.book_bookku.service.KeywordWithFilterService;
import com.example.book_bookku.service.SearchAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

//    @Autowired
//    private BookService bookService;

    private final KeywordService keywordService;
    private final KeywordWithFilterService keywordWithFilterService;
    private final SearchAllService searchAll;

    @Autowired
    public BookController(KeywordService keywordService, KeywordWithFilterService keywordWithFilterService,
                          SearchAllService searchAll) {
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

    @GetMapping("/list-filter")
    public String bookListWithFilterAndKeyword(Model model, @RequestParam("keyword") String keyword,
                               @RequestParam("filter-by") String filterBy) {

        prepareSearch(keyword, filterBy);

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filter-by", filterBy);
        return "books/booklist";
    }

    @GetMapping("/list-keyword")
    public String bookListWithKeyword(Model model, @RequestParam("keyword") String keyword) {

        prepareSearch(keyword, null);

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);
        model.addAttribute("keyword", keyword);
        return "books/booklist";
    }

    @GetMapping("/list")
    public String bookList(Model model) {

        setAllHandler();

        List<Book> bookList = searchAll.handleRequest();
        model.addAttribute("bookList", bookList);

        return "books/booklist";
    }
}
