package com.example.first.controller;

import com.example.first.model.Book;
import com.example.first.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
    }
    @PutMapping("/{id}")
    public void updateBookById(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long categoryid){
        bookService.updateBookById(id,name,author,title,categoryid);
    }
}
