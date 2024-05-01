package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService extends BookService {
//    @Override
//    public List<Book> handleRequest(String keyword, String filterBy) {
//        if (filterBy != null) {
//            nextHandler.handleRequest(keyword, filterBy.toLowerCase());
//        }
//        return bookRepository.searchAll(keyword);
//    }

    @Override
    public List<Book> handleRequest() {
        if (this.filterBy != null && !this.filterBy.isEmpty()) {
//            System.out.println(this.filterBy);
            nextHandler.setKeyword(this.keyword);
            nextHandler.setFilterBy(this.filterBy);
            return nextHandler.handleRequest();
        }
//        System.out.println("nullBro");
        return bookRepository.listAll(this.keyword);
    }
}
