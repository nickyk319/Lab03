package com.example.rest;

public class Book {
    /**
     * Class that will be used to hold the data for the Rest API Example
     */

    private final String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String newName) {
        this.author = newName;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        return String.format("The title of this book is %s, written by %s, and its isbn is %s",
                this.getTitle(), this.getAuthor(), this.getIsbn());
    }

}
