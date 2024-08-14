package com.ust.library_service.controller;


import com.ust.library_service.domain.Book;
import com.ust.library_service.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        var response= libraryService.getBookById(id)
                .orElseThrow(()->new RuntimeException("Book not found"));

        return ResponseEntity.ok(response);

    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return libraryService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        var response=libraryService.getBookById(id);
        return ResponseEntity.ok(book);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    libraryService.deleteBook(id);


        return null;
    }
}
