package com.example.book_bookku.repository;

import com.example.book_bookku.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book book1 = new Book(
                    "Buku Bagus",
                    "Andi",
                    "Halo",
                    "Buku ini keren sekali",
                    10000,
                    15,
                    LocalDate.of(2005, Month.APRIL, 3),
                    "1234567890123",
                    150,
                    "https://www.google.com/",
                    "Action"
            );

            bookRepository.saveAll(
                    List.of(book1)
            );
        };
    }
}