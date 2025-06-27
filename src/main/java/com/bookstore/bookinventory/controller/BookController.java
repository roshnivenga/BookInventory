package com.bookstore.bookinventory.controller;

import com.bookstore.bookinventory.model.Book;
import com.bookstore.bookinventory.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

   @GetMapping("/lowstock")
public List<Book> getLowStock() {
    System.out.println("LOW STOCK ENDPOINT CALLED"); 
    return bookService.findAll().stream()
        .filter(book -> book.getStockQuantity() <= 4)
        .collect(Collectors.toList());
}

}
