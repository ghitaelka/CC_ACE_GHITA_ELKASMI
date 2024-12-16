package org.example.controle.service;



import org.example.controle.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);

    boolean deleteBook(Long id);

    List<BookDTO> getBooksByTitle(String title);

    List<BookDTO> getBooksByTitleAndAuthor(String title, String author);

    List<BookDTO> saveBooks(List<BookDTO> bookDTOs);
}