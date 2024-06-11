package com.example.book_bookku.controller;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.service.BookService;
import com.example.book_bookku.service.book_list_services.KeywordService;
import com.example.book_bookku.service.book_list_services.KeywordWithFilterService;
import com.example.book_bookku.service.book_list_services.SearchAllService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;  // Initialize the BookService mock

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
    void testGetBooks() throws InterruptedException {
        // Arrange
        List<Book> expectedBooks = new ArrayList<>();
        when(bookService.getAllBooks()).thenReturn(expectedBooks);

        // Act
        ResponseEntity<List<Book>> responseEntity = bookController.getBooks();

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        verify(bookService).getAllBooks();
    }

    @Test
    void testGetBooksException() throws InterruptedException {
        // Arrange
        when(bookService.getAllBooks()).thenThrow(new RuntimeException("Exception"));

        // Act
        ResponseEntity<List<Book>> responseEntity = bookController.getBooks();

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getBody());
        verify(bookService).getAllBooks();
    }

    @Test
    void testGetBookById() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book newBook = new Book();
        newBook.setId(bookId);

        when(bookService.createBook(newBook)).thenReturn(newBook);
        when(bookService.getBookById(bookId)).thenReturn(Optional.of(newBook));

        // Act
        ResponseEntity<Book> savedBookResponse = bookController.createBook(newBook);
        ResponseEntity<Book> retrievedBookResponse = bookController.getBookById(bookId);

        // Assert
        assertEquals(HttpStatus.CREATED, savedBookResponse.getStatusCode());
        assertEquals(HttpStatus.CREATED, retrievedBookResponse.getStatusCode());
        assertNotNull(retrievedBookResponse.getBody());
        assertEquals(savedBookResponse.getHeaders(), retrievedBookResponse.getHeaders());
        verify(bookService).createBook(newBook);
        verify(bookService).getBookById(bookId);
    }

    @Test
    void testGetBookByIdException() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        when(bookService.getBookById(bookId)).thenThrow(new RuntimeException("Exception"));

        // Act
        ResponseEntity<Book> responseEntity = bookController.getBookById(bookId);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getBody());
        verify(bookService).getBookById(bookId);
    }

    @Test
    void testCreateBook() {
        // Arrange
        Book book = new Book();
        when(bookService.createBook(book)).thenReturn(book);

        // Act
        ResponseEntity<Book> responseEntity = bookController.createBook(book);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(book, responseEntity.getBody());
        verify(bookService).createBook(book);
    }

    @Test
    void testDeleteBook() {
        // Arrange
        UUID bookId = UUID.randomUUID();

        // Act
        String response = bookController.deleteBook(bookId);

        // Assert
        assertEquals("success", response);
        verify(bookService).deleteBookById(bookId);
    }

    @Test
    void testUpdateBook() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book book = new Book();
        when(bookService.editBook(bookId, book)).thenReturn(book);

        // Act
        String response = bookController.updateBook(bookId, book);

        // Assert
        assertEquals("success", response);
        verify(bookService).editBook(bookId, book);
    }

    @Test
    void testBookBought() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        int quantity = 2;
        Book expectedBook = new Book();
        expectedBook.setId(bookId);
        // Set other fields of expectedBook if necessary

        // Mock the bookService behavior
        when(bookService.bookBought(bookId, quantity)).thenReturn(expectedBook);

        // Create an ObjectNode to simulate the request body
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("id", bookId.toString());
        objectNode.put("quantity", quantity);

        // Act
        Book actualBook = bookController.bookBought(objectNode);

        // Assert
        assertEquals(expectedBook, actualBook);
    }

    @Test
    void testBookListWithFilterAndKeyword() {
        // Arrange
        String keyword = "keyword";
        String filterBy = "filterBy";
        String sortBy = "sortBy";
        String sortDir = "sortDir";
        List<Book> expectedBookList = new ArrayList<>();
        when(searchAllService.handleRequest()).thenReturn(expectedBookList);

        // Act
        List<Book> result = bookController.bookListBy(model, keyword, filterBy, sortBy, sortDir);

        // Assert
        assertEquals(expectedBookList, result);
        verify(searchAllService).setKeyword(keyword);
        verify(searchAllService).setFilterBy(filterBy);
        verify(searchAllService).setSortBy(sortBy);
        verify(searchAllService).setSortDir(sortDir);
        verify(searchAllService).setNextHandler(keywordService);
        verify(keywordService).setNextHandler(keywordWithFilterService);
        verify(model).addAttribute("bookList", expectedBookList);
        verify(model).addAttribute("keyword", keyword);
        verify(model).addAttribute("filter-by", filterBy);
        verify(model).addAttribute("sort-by", sortBy);
        verify(model).addAttribute("sort-dir", sortDir);
    }
}
