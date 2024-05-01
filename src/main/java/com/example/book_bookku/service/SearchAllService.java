package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchAllService extends BookService {

//    @Override
//    public List<Book> handleFilterRequest(String keyword, String filterBy) {
//        if (keyword != null) {
//            return nextHandler.handleRequest(keyword.toLowerCase(), filterBy);
//        }
//        return bookRepository.findAll();
//    }
//
//    @Override
//    public List<Book> handleKeywordRequest(String keyword) {
//        if (keyword != null) {
//            return bookRepository.searchAll(keyword);
//        }
//        return bookRepository.findAll();
//    }
    @Override
    public List<Book> handleRequest() {
        if (this.keyword != null && !this.keyword.isEmpty()) {
//            System.out.println(this.keyword);
            nextHandler.setKeyword(this.keyword);
            nextHandler.setFilterBy(this.filterBy);
//            System.out.println(this.filterBy);
            return nextHandler.handleRequest();
        }

        return bookRepository.findAll();
    }
}
