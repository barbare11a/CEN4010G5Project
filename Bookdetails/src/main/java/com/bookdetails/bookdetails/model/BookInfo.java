package com.bookdetails.bookdetails.model;

import javax.persistence.*;


@Entity
@Table(name = "Bookinfo")
public class BookInfo {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "isbn")
    private Integer isbn;
    private String title;
    private String author;
    private String description;
    private Integer price;
    private String genre;
    private String publisher;
    private Integer yearPublished;

    @Column(name = "CopiesSold")
    private Integer copiesSold;

    public BookInfo(Integer isbn,String title, String author, String description, Integer price,
                    String genre, String publisher, Integer yearPublished, Integer copiesSold) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }


    public Integer getId(){
        return Id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer ibsn) {
        this.isbn = ibsn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    public BookInfo(){}
}
