package com.aksoyakin.librarymanagementbe.service;

import com.aksoyakin.librarymanagementbe.model.entity.AuthorEntity;
import com.aksoyakin.librarymanagementbe.model.entity.BookEntity;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import com.aksoyakin.librarymanagementbe.dto.converter.BookConverter;
import com.aksoyakin.librarymanagementbe.model.dto.book.request.BookCreateRequest;
import com.aksoyakin.librarymanagementbe.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookDto createBook(
            final BookCreateRequest request
    ) {
        final BookEntity bookEntityToBeSave = BookConverter.mapForSaving(request);

        final AuthorDto authorDto = authorService.getAuthorById(request.getAuthorId());

        bookEntityToBeSave.setAuthorEntity(AuthorEntity.builder().id(authorDto.getId()).build());

        bookRepository.save(bookEntityToBeSave);

        return BookConverter.toDto(bookEntityToBeSave);
    }

    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return BookConverter.toDto(bookEntities);
    }

    public BookDto getBookByName(String name) {
        Optional<BookEntity> book = bookRepository.findByName(name);
        return BookConverter.toDto(book.orElseThrow(() -> new RuntimeException("Book not found.")));
    }

    public List<BookDto> findBooksByAuthor(String name) {
        //Optional<List<BookEntity>> books = bookRepository.findByAuthorName(name);
        //return BookConverter.toDto(books);
        return List.of();
    }
}
