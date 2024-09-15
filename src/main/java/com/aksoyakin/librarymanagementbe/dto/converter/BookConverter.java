package com.aksoyakin.librarymanagementbe.dto.converter;

import com.aksoyakin.librarymanagementbe.domain.Book;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import org.springframework.stereotype.Component;

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
}
