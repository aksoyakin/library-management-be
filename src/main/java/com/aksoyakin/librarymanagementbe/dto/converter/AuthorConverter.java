package com.aksoyakin.librarymanagementbe.dto.converter;

import com.aksoyakin.librarymanagementbe.model.entity.AuthorEntity;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorConverter {

    public AuthorDto toDto(
            final AuthorEntity entity
    ) {
        return AuthorDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public AuthorDto convertToDto(AuthorEntity from) {
        return AuthorDto.builder()
                .id(from.getId())
                .name(from.getName())
                .build();
    }

    public AuthorEntity convertToEntity(AuthorDto from) {
        return AuthorEntity.builder()
                .id(from.getId())
                .name(from.getName())
                .build();

    }
}
