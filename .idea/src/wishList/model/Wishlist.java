package com.demo.wishList.model;
import java.time.LocalDate;

public class Wishlist {
    private String name;
    private LocalDate dateCreated;
    private String book;
    private String user;


    public Wishlist(String name,
                    LocalDate dateCreated,
                    String book,
                    String user) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.book = book;
        this.user = user;
    }

    public Wishlist() {
    }

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Wishlist wishlist = (Wishlist) object;
        return java.util.Objects.equals(name, wishlist.name)
                && java.util.Objects.equals(dateCreated, wishlist.dateCreated)
                && java.util.Objects.equals(book, wishlist.book)
                && java.util.Objects.equals(user, wishlist.user);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, dateCreated, book, user);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", book='" + book + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
