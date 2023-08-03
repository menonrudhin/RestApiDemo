package com.example.test.RestApiDemo;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "BOOK_SEQ", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private int published;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                '}';
    }
}
