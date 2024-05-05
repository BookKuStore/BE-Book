package com.example.book_bookku.controller;

<<<<<<< HEAD
import com.example.book_bookku.model.Book;
=======
import com.example.book_bookku.service.book_list_services.KeywordService;
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
<<<<<<< HEAD
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

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

=======
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private KeywordService keywordService;

    @Mock
    private KeywordWithFilterService keywordWithFilterService;

    @Mock
    private SearchAllService searchAllService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBookListWithFilterAndKeyword() {
        // Arrange
        String keyword = "keyword";
        String filterBy = "filterBy";
        List<Book> expectedBookList = new ArrayList<>();
        when(searchAllService.handleRequest()).thenReturn(expectedBookList);

        // Act
        List<Book> result = bookController.bookListWithFilterAndKeyword(model, keyword, filterBy);

        // Assert
        assertEquals(expectedBookList, result);
        verify(searchAllService).setKeyword(keyword);
        verify(searchAllService).setFilterBy(filterBy);
        verify(searchAllService).setNextHandler(keywordService);
        verify(keywordService).setNextHandler(keywordWithFilterService);
        verify(model).addAttribute("bookList", expectedBookList);
        verify(model).addAttribute("keyword", keyword);
        verify(model).addAttribute("filter-by", filterBy);
    }

    @Test
    void testBookListWithKeyword() {
        // Arrange
        String keyword = "keyword";
        List<Book> expectedBookList = new ArrayList<>();
        when(searchAllService.handleRequest()).thenReturn(expectedBookList);

        // Act
        List<Book> result = bookController.bookListWithKeyword(model, keyword);

        // Assert
        assertEquals(expectedBookList, result);
        verify(searchAllService).setKeyword(keyword);
        verify(searchAllService).setFilterBy(null);
        verify(searchAllService).setNextHandler(keywordService);
        verify(keywordService).setNextHandler(keywordWithFilterService);
        verify(model).addAttribute("bookList", expectedBookList);
        verify(model).addAttribute("keyword", keyword);
    }

    @Test
    void testBookList() {
        // Arrange
        List<Book> expectedBookList = new ArrayList<>();
        when(searchAllService.handleRequest()).thenReturn(expectedBookList);

        // Act
        List<Book> result = bookController.bookList(model);

        // Assert
        assertEquals(expectedBookList, result);
        verify(searchAllService).setNextHandler(keywordService);
        verify(keywordService).setNextHandler(keywordWithFilterService);
        verify(model).addAttribute("bookList", expectedBookList);
    }
}
>>>>>>> 107262a05ba5f00f8964cdc87a79a672dc22e0bb
