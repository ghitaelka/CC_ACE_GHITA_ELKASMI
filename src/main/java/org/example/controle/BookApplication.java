package org.example.controle;

import org.example.controle.dto.BookDTO;
import org.example.controle.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BookService bookService) {
        return args -> {
            bookService.saveBooks(
                    List.of(
                            BookDTO.builder().titre("Spring in Action").publisher("Manning").datePublication("2023-01-01").price(39.99).resume("A complete guide to Spring Framework").build(),
                            BookDTO.builder().titre("Effective Java").publisher("Addison-Wesley").datePublication("2018-01-06").price(49.99).resume("Best practices for Java programming").build(),
                            BookDTO.builder().titre("Clean Code").publisher("Prentice Hall").datePublication("2008-08-11").price(45.99).resume("A handbook of agile software craftsmanship").build(),
                            BookDTO.builder().titre("The Pragmatic Programmer").publisher("Addison-Wesley").datePublication("1999-10-20").price(39.50).resume("Your journey to mastery").build()
                    )
            );
        };
    }

}
