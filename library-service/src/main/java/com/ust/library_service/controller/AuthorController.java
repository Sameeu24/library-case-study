package com.ust.library_service.controller;


import com.ust.library_service.domain.Author;
import com.ust.library_service.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController   {

    private final LibraryService libraryService;


    public AuthorController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping //
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id) {

        var response=libraryService.getAuthorById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return  libraryService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        // Fetch the existing author from the database
        var exisitingAuthor=libraryService.getAuthorById(id).orElseThrow(()->new RuntimeException("Authorn't"));
        exisitingAuthor.setName(author.getName());
        exisitingAuthor.setBooks(author.getBooks());
        libraryService.saveAuthor(exisitingAuthor);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {

        libraryService.deleteAuthor(id);

        return ResponseEntity.ok(null);
    }
}
