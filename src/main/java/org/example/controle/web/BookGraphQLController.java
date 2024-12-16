package org.example.controle.web;

import lombok.AllArgsConstructor;

import org.example.controle.dto.BookDTO;
import org.example.controle.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookGraphQLController {

    private final BookService bookService;

    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping
    public BookDTO saveBook(@Argument BookDTO book) {
        return bookService.saveBook(book);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }

    @QueryMapping
    public List<BookDTO> getBooksByTitle(@Argument String title) {
        return bookService.getBooksByTitle(title);
    }

    @QueryMapping
    public List<BookDTO> getBooksByTitleAndAuthor(@Argument String title, @Argument String author) {
        return bookService.getBooksByTitleAndAuthor(title, author);
    }
}
