package com.example.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Path("book")
public class BookRest {

    /**
     * Class for holding the list of customers and handling the requests
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
    public String getCustomerList(@PathParam("title") String title) {
        Book customer = library.stream().filter(customer1 -> customer1.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        if (customer != null) {
            return customer.toString();
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
        library = library.stream().filter(customer -> !customer.getTitle().equals(title))
                .collect(Collectors.toCollection(ArrayList::new));
        Book newCustomer = new Book(title, author, isbn);
        library.add(newCustomer);
    }

}
