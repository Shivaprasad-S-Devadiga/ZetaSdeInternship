package com.shiva.demo.controller;

import com.shiva.demo.entity.Book;
import com.shiva.demo.services.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping("/author/{name}")
    public List<Book> byAuthor(@PathVariable String name) {
        return service.findByAuthor(name);
    }

    @GetMapping("/expensive/{price}")
    public List<Book> expensiveBooks(@PathVariable  double price){
        return  service.expensiveBooks(price);
    }

}
