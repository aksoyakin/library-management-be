package com.aksoyakin.librarymanagementbe.service;

import com.aksoyakin.librarymanagementbe.domain.Author;
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
    private final AuthorConverter authorConverter;

    public AuthorDto createAuthor(String authorName){
        Optional<Author> existingAuthor = authorRepository.findByName(authorName);
        if(existingAuthor.isPresent()){
            return authorConverter.convertToDto(existingAuthor.get());
        } else {
            Author newAuthor = Author.builder()
                    .name(authorName)
                    .build();
            Author savedAuthor = authorRepository.save(newAuthor);
            return authorConverter.convertToDto(savedAuthor);
        }
    }
}
