package com.example.book_bookku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BookBookkuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookBookkuApplication.class, args);
	}

}
