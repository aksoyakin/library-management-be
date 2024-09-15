package com.aksoyakin.librarymanagementbe.service;

import com.aksoyakin.librarymanagementbe.domain.Book;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import com.aksoyakin.librarymanagementbe.dto.converter.AuthorConverter;
import com.aksoyakin.librarymanagementbe.dto.converter.BookConverter;
import com.aksoyakin.librarymanagementbe.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
