package com.example.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Path("book")
public class BookRest {

    /**
     * Class for holding the list of Books and handling the requests
     */
    private static ArrayList<Book> library = new ArrayList<>();

    @GET
    @Produces("application/xml")
    public ArrayList<Book> getBook(){
        return library;
    }

    /**
     * Meant for getting a book with a specific title
     * @param title of the book
     * @return toString method of book
     */
    @GET
    @Produces("application/xml")
    @Path("{title}")
    public Book getBook(@PathParam("title") String title) {
        return library.stream().filter(theBook -> theBook.getTitle().equals(title))
                .findFirst()
                .orElse(null);

    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void createBook(@FormParam("title") String title, @FormParam("author") String author, @FormParam("isbn") String isbn){
        Book newBook = new Book(title, author, isbn);
        library.add(newBook);
    }

    /**
     * Meant for replacing book with specific title
     *
     */
    @PUT
    @Consumes("application/xml")
    public void modifyBook(Book book) {
        library = library.stream().filter(theBook -> !theBook.getTitle().equals(book.title))
                .collect(Collectors.toCollection(ArrayList::new));
        Book newBook = new Book(book);
        library.add(newBook);
    }

}
