package com.bookdetails.bookdetails.controller;

import com.bookdetails.bookdetails.model.AuthorInfo;
import com.bookdetails.bookdetails.model.BookInfo;
import com.bookdetails.bookdetails.repository.MySqlRepository;
import com.bookdetails.bookdetails.repository.MySqlRespoAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    @Autowired
    MySqlRespoAuth mySqlRespoAuth;

    @GetMapping("/get-all-authors")
    public List<AuthorInfo> getAllAuthors(){

        return mySqlRespoAuth.findAll();
    }

    @PostMapping("/add-author")
    public AuthorInfo create(@RequestBody Map<String, String> body){

        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String bio = body.get("bio");
        String authorPublisher = body.get("autPublisher");

        AuthorInfo newAuthor = new AuthorInfo(firstName, lastName,bio,authorPublisher);

        return mySqlRespoAuth.save(newAuthor);

    }

    @GetMapping("/get-book/author/{lastName}")
    public AuthorInfo getAllBooksByAuthor(@PathVariable String lastName){
        return mySqlRespoAuth.findByLastName(lastName).get();
    }

}
