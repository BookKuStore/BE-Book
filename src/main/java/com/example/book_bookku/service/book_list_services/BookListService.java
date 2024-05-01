package com.example.book_bookku.service.book_list_services;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BookListService {

    @Autowired
    protected BookRepository bookRepository;

    @Setter@Getter
    protected BookListService nextHandler;
    @Setter@Getter
    protected String keyword;
    @Setter@Getter
    protected String filterBy;

    public abstract List<Book> handleRequest();

}
