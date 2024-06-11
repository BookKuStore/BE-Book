package com.example.book_bookku.service;

import com.example.book_bookku.model.Book;
import com.example.book_bookku.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() throws InterruptedException {
        // Arrange
        List<Book> expectedBooks = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.getAllBooks();

        // Assert
        assertEquals(expectedBooks, actualBooks);
        verify(bookRepository).findAll();
    }

    @Test
    void testGetBookById() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book expectedBook = new Book();
        expectedBook.setId(bookId);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        // Act
        Optional<Book> actualBook = bookService.getBookById(bookId);

        // Assert
        assertTrue(actualBook.isPresent());
        assertEquals(expectedBook, actualBook.get());
        verify(bookRepository).findById(bookId);
    }

    @Test
    void testCreateBook() {
        // Arrange
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        // Act
        Book createdBook = bookService.createBook(book);

        // Assert
        assertEquals(book, createdBook);
        verify(bookRepository).save(book);
    }

    @Test
    void testDeleteBookById() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book book = new Book();
        book.setId(bookId);
        when(bookRepository.getReferenceById(bookId)).thenReturn(book);

        // Act
        bookService.deleteBookById(bookId);

        // Assert
        verify(bookRepository).deleteById(bookId);
    }

    @Test
    void testDeleteBookByIdThrowsError() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book book = new Book();
        book.setId(bookId);
        book.setBuy_count(1);
        when(bookRepository.getReferenceById(bookId)).thenReturn(book);

        // Act & Assert
        assertThrows(Error.class, () -> bookService.deleteBookById(bookId));
        verify(bookRepository, never()).deleteById(bookId);
    }

    @Test
    void testEditBook() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        Book book = new Book();
        Book editedBook = new Book();
        editedBook.setId(bookId);
        when(bookRepository.getReferenceById(bookId)).thenReturn(editedBook);
        when(bookRepository.save(editedBook)).thenReturn(editedBook);

        // Act
        Book result = bookService.editBook(bookId, book);

        // Assert
        assertEquals(editedBook, result);
        verify(bookRepository).getReferenceById(bookId);
        verify(bookRepository).save(editedBook);
    }

    @Test
    void testBookBought() {
        // Arrange
        UUID bookId = UUID.randomUUID();
        int quantity = 2;
        Book book = new Book();
        book.setId(bookId);
        book.setBuy_count(0);
        when(bookRepository.getReferenceById(bookId)).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);

        // Act
        Book boughtBook = bookService.bookBought(bookId, quantity);

        // Assert
        assertEquals(quantity, boughtBook.getBuy_count());
        verify(bookRepository).getReferenceById(bookId);
        verify(bookRepository).save(boughtBook);
    }
}
