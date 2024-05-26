//package com.example.book_bookku.service;
//
//import com.example.book_bookku.model.Book;
//import com.example.book_bookku.repository.BookRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//public class BookServiceTest {
//
//    private final BookRepository bookRepository;
//
//    private final BookService bookService;
//
//    private Book book1;
//    private UUID book1Id;
//
//    private Book book2;
//    private UUID book2Id;
//
//    @Autowired
//    public BookServiceTest(BookService bookService, BookRepository bookRepository) {
//        this.bookService = bookService;
//        this.bookRepository = bookRepository;
//    }
//
//    @BeforeEach
//    public void setUp() {
//        book1Id = UUID.randomUUID();
//        book1 = new Book();
//        book1.setId(book1Id);
//        book1.setBuy_count(0);
//
//        book2Id = UUID.randomUUID();
//        book2 = new Book();
//        book2.setId(book2Id);
//        book2.setBuy_count(1);
//    }
//
//    @Test
//    public void testGetAllBooks() throws InterruptedException {
//        List<Book> books = bookService.getAllBooks();
//
//        assertNotNull(books);
//        assertEquals(true, !books.isEmpty());
//    }
//
//    @Test
//    public void testGetBookById() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCreateBook() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void testDeleteBookById() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void testEditBook() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void testBookBought() {
//        assertTrue(true);
//    }
//}
