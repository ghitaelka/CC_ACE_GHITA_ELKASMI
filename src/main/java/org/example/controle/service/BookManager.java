package org. example.controle.service;


import lombok.AllArgsConstructor;
import org.example.controle.dao.repositories.BookRepository;
import org.example.controle.dto.BookDTO;
import org.example.controle.mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.example.controle.dao.entities.Book;
import java.util.ArrayList;
import java.util.List;

@Service


public class BookManager implements BookService{

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookManager(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.fromBookDtoToBook(bookDTO);
        book = bookRepository.save(book);
        return bookMapper.fromBookToBookDto(book);
    }

    @Override
    public boolean deleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<BookDTO> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(bookMapper.fromBookToBookDto(book));
        }
        return bookDTOs;
    }

    @Override
    public List<BookDTO> getBooksByTitleAndAuthor(String title, String author) {
        return List.of();
    }


    @Override
    public List<BookDTO> saveBooks(List<BookDTO> bookDTOs) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOs) {
            books.add(bookMapper.fromBookDtoToBook(bookDTO));
        }

        books = bookRepository.saveAll(books);

        List<BookDTO> savedBookDTOs = new ArrayList<>();
        for (Book book : books) {
            savedBookDTOs.add(bookMapper.fromBookToBookDto(book));
        }
        return savedBookDTOs;
    }
}