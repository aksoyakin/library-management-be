package com.aksoyakin.librarymanagementbe.controller;

import com.aksoyakin.librarymanagementbe.dto.AuthorDto;
import com.aksoyakin.librarymanagementbe.dto.BookDto;
import com.aksoyakin.librarymanagementbe.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto createdBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{bookName}")
    public ResponseEntity<BookDto> getBookByName(@PathVariable("bookName") String name) {
        return ResponseEntity.ok(bookService.getBookByName(name));
    }

    @GetMapping("/author/{authorName}")
    public List<BookDto> findBooksByAuthor(@PathVariable("authorName") String name){
        return bookService.findBooksByAuthor(name);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
