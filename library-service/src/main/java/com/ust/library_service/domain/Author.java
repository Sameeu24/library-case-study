package com.ust.library_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    private Long id;
    private String name;

    // One author can have multiple books

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;
}