package com.aksoyakin.librarymanagementbe.repository;

import com.aksoyakin.librarymanagementbe.model.Author;
import com.aksoyakin.librarymanagementbe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);
    Optional<List<Book>> findByAuthorName(String name);
}
