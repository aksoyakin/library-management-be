package com.aksoyakin.librarymanagementbe.repository;

import com.aksoyakin.librarymanagementbe.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
