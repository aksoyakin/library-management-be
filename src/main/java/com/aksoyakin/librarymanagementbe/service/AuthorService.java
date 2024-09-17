package com.aksoyakin.librarymanagementbe.service;

import com.aksoyakin.librarymanagementbe.model.entity.AuthorEntity;
import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.dto.converter.AuthorConverter;
import com.aksoyakin.librarymanagementbe.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorDto createAuthor(String authorName){
        Optional<AuthorEntity> existingAuthor = authorRepository.findByName(authorName);
        if(existingAuthor.isPresent()){
            return AuthorConverter.convertToDto(existingAuthor.get());
        } else {
            AuthorEntity newAuthorEntity = AuthorEntity.builder()
                    .name(authorName)
                    .build();
            AuthorEntity savedAuthorEntity = authorRepository.save(newAuthorEntity);
            return AuthorConverter.convertToDto(savedAuthorEntity);
        }
    }


    public AuthorDto getAuthorById(
            final Long authorId
    ) {
        final AuthorEntity authorEntityFromDB = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with given id: " + authorId));

        return AuthorConverter.toDto(authorEntityFromDB);
    }
}
