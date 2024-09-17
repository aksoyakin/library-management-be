package com.aksoyakin.librarymanagementbe.controller;

import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.model.dto.author.request.AuthorCreateRequest;
import com.aksoyakin.librarymanagementbe.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(
            @RequestBody final AuthorCreateRequest request
    ) {
        AuthorDto authorDto = authorService.createAuthor(request.getName());
        return ResponseEntity.ok(authorDto);
    }
}
