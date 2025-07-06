package com.example.test.RestApiDemo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    private StringBuilder response = new StringBuilder();

    @PostMapping(path = "/create")
    public Book post(@RequestBody Book book){
        Book createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get/{id}")
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

    @PutMapping(path = "/update")
    public Book put(@RequestBody Book book){
        Optional<Book> bookOpt = bookRepository.findById(book.getId());
        bookOpt.orElseThrow();
        Book updatedBook = bookRepository.save(book);

        return updatedBook;
    }

    @RequestMapping("/rm/{id}")
    public void delete(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
    }

    @GetMapping
    public String getVer() {
        return "v0.1.7";
    }

}
