package com.example.book_bookku.service.book_list_services;

import com.example.book_bookku.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService extends BookListService {
    @Override
    public List<Book> handleRequest() {
        if (this.filterBy != null && !this.filterBy.isEmpty()) {
            nextHandler.setKeyword(this.keyword);
            nextHandler.setFilterBy(this.filterBy);
            return nextHandler.handleRequest();
        }
        return bookRepository.listAll(this.keyword);
    }
}
