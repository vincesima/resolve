package com.resolve.book;

import com.resolve.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://vincesima.com", "http://www.vincesima.com", "http://localhost:8100"})
public class BookController {
    @Autowired
    BookRepo repo;

    @Autowired
    Utilities utilities;

    @GetMapping(path = "/books")
    public List<Book> getAll(){
        return repo.findAll();
    }

    @GetMapping(path = "/books/{id}")
    public Book getBook(@PathVariable long id){
        Book book = null;
        for(Book book0 : repo.findAll()){
            if(book0.getId() == id){
                book = book0;
            }
        }
        return book;
    }

    @PostMapping(path = "/books", consumes = "application/json", produces = "application/json")
    public void addBook(@RequestBody Book book) {
        repo.save(book);
    }

    @PutMapping(path = "/books/update/{bookId}", consumes = "application/json", produces = "application/json")
    public void updateBook(@PathVariable Long bookId, @RequestBody Book book){
        Book update = utilities.getBook(bookId);
        update.setProgress(book.getProgress());
        repo.save(update);
    }

}
