package com.example.first.service;

import com.example.first.model.Book;
import com.example.first.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) {
        Optional<Book> boo1 = bookRepository.findByName(book.getName());
        if(boo1.isPresent()){
            throw new IllegalArgumentException("book da ton tai");
        }
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        boolean bookExits = bookRepository.existsById(id);
        if(!bookExits){
            throw new IllegalStateException("book by id "+id +" not exits");
        }
        bookRepository.deleteById(id);
    }

    public void updateBookById(Long id,String name, String author, String title, Long categoryid) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("book not exits"));
        if(name!=null)  book.setName(name);
        if(author!=null)  book.setAuthor(author);
        if(title!=null)  book.setTitle(title);
        if(categoryid!=null)  book.setCategoryID(categoryid);
        bookRepository.save(book);
    }
}
