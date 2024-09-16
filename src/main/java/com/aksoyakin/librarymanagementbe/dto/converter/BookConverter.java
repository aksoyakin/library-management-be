package com.aksoyakin.librarymanagementbe.dto.converter;

import com.aksoyakin.librarymanagementbe.model.Book;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookConverter {

    public BookDto convertToDto(Book from) {
        return BookDto.builder()
                .id(from.getId())
                .name(from.getName())
                .authorName(from.getAuthor().getName())
                .category(from.getCategory())
                .build();
    }

    public List<BookDto> convertToDto(Optional<List<Book>> books) {
        return books
                .orElseGet(Collections::emptyList)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> convertToDto(List<Book> books) {
        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
