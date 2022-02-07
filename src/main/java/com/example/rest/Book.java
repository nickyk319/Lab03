package com.example.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    /**
     * Class that will be used to hold the data for the Rest API Example
     */
    @XmlElement
    protected String title;
    @XmlElement
    protected String author;
    @XmlElement
    protected String isbn;

    public Book(Book book){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public Book(){

    }

    public void serTitle(String title){
        this.title = title;
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
