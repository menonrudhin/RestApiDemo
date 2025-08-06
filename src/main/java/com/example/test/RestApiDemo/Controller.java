package com.example.test.RestApiDemo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {

    @Value("#{${app.timezone}}")
    private Map<String, String> timezone;

    private StringBuilder response = new StringBuilder();

    @PostConstruct
    public void postConstruct() {
        timezone.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " : " + e.getValue());
        });
    }

    @PostMapping(path = "/create")
    public Book post(@RequestBody Book book){
        Book createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Autowired
    private BookRepository bookRepository;

    @Transactional
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
