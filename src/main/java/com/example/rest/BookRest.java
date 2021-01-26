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

    /**
     * Meant for getting a book with a specific title
     * @param title of the book
     * @return toString method of book
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{title}")
    public String getBook(@PathParam("title") String title) {
        Book book = library.stream().filter(theBook -> theBook.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        if (book != null) {
            return book.toString();
        } else {
            return "";
        }
    }

    /**
     * Meant for replacing book with specific title
     * @param title of the book
     * @param author of the book
     * @param isbn of the book
     */
    @PUT
    @Path("{title}/{author}/{isbn}")
    public void modifyBook(@PathParam("title") String title, @PathParam("author") String author,
                               @PathParam("isbn") String isbn) {
        library = library.stream().filter(book -> !book.getTitle().equals(title))
                .collect(Collectors.toCollection(ArrayList::new));
        Book newBook = new Book(title, author, isbn);
        library.add(newBook);
    }

}
