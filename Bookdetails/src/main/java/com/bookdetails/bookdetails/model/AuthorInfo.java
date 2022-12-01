package com.bookdetails.bookdetails.model;
import javax.persistence.*;


@Entity
@Table(name = "Author")
public class AuthorInfo {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer autId;
    private String firstName;
    private String lastName;
    private String bio;
    private String autPublisher;

    public AuthorInfo(String firstName, String lastName, String bio, String autPublisher){
        this.firstName =firstName;
        this.lastName = lastName;
        this.bio =bio;
        this.autPublisher =autPublisher;
    }

    public AuthorInfo() {

    }

    public Integer getAutId(){
        return autId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAutPublisher() {
        return autPublisher;
    }

    public void setAutPublisher(String autPublisher) {
        this.autPublisher = autPublisher;
    }
}
