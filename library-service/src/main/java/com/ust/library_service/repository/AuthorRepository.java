package com.ust.library_service.repository;

import com.ust.library_service.domain.Author;
import com.ust.library_service.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}
