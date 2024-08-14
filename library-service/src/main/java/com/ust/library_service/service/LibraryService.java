package com.ust.library_service.service;


import com.ust.library_service.domain.Author;
import com.ust.library_service.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibraryService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);




}
