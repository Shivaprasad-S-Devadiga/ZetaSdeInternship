package com.shiva.demo.repository;

import com.shiva.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByPriceGreaterThan(Double price);

    @Query("SELECT b FROM Book b WHERE b.price > :price")
    List<Book> expensiveBooks(Double price);

}
