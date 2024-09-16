package com.aksoyakin.librarymanagementbe.service;

import com.aksoyakin.librarymanagementbe.model.Book;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import com.aksoyakin.librarymanagementbe.dto.converter.AuthorConverter;
import com.aksoyakin.librarymanagementbe.dto.converter.BookConverter;
import com.aksoyakin.librarymanagementbe.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final AuthorService authorService;
    private final AuthorConverter authorConverter;

    public BookDto createBook(BookDto bookDto) {
        AuthorDto authorDto = authorService.createAuthor(bookDto.getAuthorName());

        Book book = Book.builder()
                .name(bookDto.getName())
                .category(bookDto.getCategory())
                .author(authorConverter.convertToEntity(authorDto))
                .build();

        bookRepository.save(book);
        return bookConverter.convertToDto(book);
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookConverter.convertToDto(books);
    }

    public BookDto getBookByName(String name) {
        Optional<Book> book = bookRepository.findByName(name);
        return bookConverter.convertToDto(book.orElseThrow(() -> new RuntimeException("Book not found.")));
    }

    public List<BookDto> findBooksByAuthor(String name) {
        Optional<List<Book>> books = bookRepository.findByAuthorName(name);
        return bookConverter.convertToDto(books);
    }
}
