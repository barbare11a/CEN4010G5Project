package com.demo.wishList.model;
import java.time.LocalDate;

public class Wishlist {
    private String name;
    private LocalDate dateCreated;
    private String book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }



}
