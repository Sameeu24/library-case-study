package com.ust.library_service.service;

import com.ust.library_service.domain.Author;
import com.ust.library_service.domain.Book;
import com.ust.library_service.repository.AuthorRepository;
import com.ust.library_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibraryServiceImpl implements LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return  authorRepository.findById(id);
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.saveAndFlush(   author);
    }

    @Override
    public void deleteAuthor(Long id) {
        var author=authorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Author not found"));

    authorRepository.delete(author);



    }

    @Override
    public List<Book> getAllBooks() {
        return List.copyOf(bookRepository.findAll());
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return   bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        var book=bookRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));

    }
}
