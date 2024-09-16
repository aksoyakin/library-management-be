package com.aksoyakin.librarymanagementbe.dto.converter;

import com.aksoyakin.librarymanagementbe.model.Author;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDto convertToDto(Author from) {
        return AuthorDto.builder()
                .id(from.getId())
                .name(from.getName())
                .build();
    }

    public Author convertToEntity(AuthorDto from) {
        return Author.builder()
                .id(from.getId())
                .name(from.getName())
                .build();

    }
}
