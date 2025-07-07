package com.example.test.RestApiDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/create")
    public Book post(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") int id){
        Book book = (Book) bookRepository.getReferenceById(id);
        return book.toString();
    }

    @RequestMapping("/update")
    public Book put(@RequestBody Book book){
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

}
