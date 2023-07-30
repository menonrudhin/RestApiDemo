package com.example.test.RestApiDemo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private StringBuilder response = new StringBuilder();

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/create")
    public Book post(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") int id){
        try {
            Book book = bookRepository.getReferenceById(id);
            response.delete(0, response.length());
            response.append(book);
        } catch (EntityNotFoundException e){
            response.delete(0, response.length());
            response.append("ERROR");
        }
        return response.toString();
    }

    @RequestMapping("/update")
    public Book put(@RequestBody Book book){
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    @RequestMapping("/rm/{id}")
    public void delete(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
    }

}
