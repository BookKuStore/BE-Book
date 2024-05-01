package com.example.book_bookku.controller;

import com.example.book_bookku.controller.BookController;
import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.KeywordService;
import com.example.book_bookku.service.KeywordWithFilterService;
import com.example.book_bookku.service.SearchAllService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookControllerTest {

    @Mock
    private KeywordService keywordService;
    @Mock
    private KeywordWithFilterService keywordWithFilterService;
    @Mock
    private SearchAllService searchAllService;
    @Mock
    Model model;
    @InjectMocks
    private BookController bookController;


    @Test
    public void testBookListWithFilterAndKeyword() {
        String page = bookController.bookListWithFilterAndKeyword(model, "pen", "penulis");
        assertEquals("books/booklist", page);
    }

    @Test
    public void testBookListWithKeyword() {
        String page = bookController.bookListWithKeyword(model, "pen");
        assertEquals("books/booklist", page);
    }

    @Test
    public void testBookList() {
        String page = bookController.bookList(model);
        assertEquals("books/booklist", page);
    }
}

