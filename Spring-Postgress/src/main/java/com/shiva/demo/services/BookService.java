package com.shiva.demo.services;

import com.shiva.demo.entity.Book;
import com.shiva.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public  List<Book> expensiveBooks(@Param("price") Double price){
        return  repository.expensiveBooks(price);
    }

}
