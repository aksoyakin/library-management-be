package com.aksoyakin.librarymanagementbe.dto.converter;

import com.aksoyakin.librarymanagementbe.model.entity.BookEntity;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import com.aksoyakin.librarymanagementbe.model.dto.book.request.BookCreateRequest;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class BookConverter {

    public BookEntity mapForSaving(
            final BookCreateRequest request
    ) {
        return BookEntity.builder()
                .name(request.getName())
                .category(request.getCategory())
                .build();
    }

    public BookDto toDto(
            final BookEntity entity
    ) {
        return BookDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .authorName(entity.getAuthorEntity().getName())
                .category(entity.getCategory())
                .build();
    }

    public List<BookDto> toDto(Optional<List<BookEntity>> books) {
        return books
                .orElseGet(Collections::emptyList)
                .stream()
                .map(BookConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> toDto(List<BookEntity> bookEntities) {
        return bookEntities.stream()
                .map(BookConverter::toDto)
                .collect(Collectors.toList());
    }

}
