package com.ust.library_service.repository;

import com.ust.library_service.domain.Book;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book,Long> {


    Optional<Book> getBookById(long Id);




}
