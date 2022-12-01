package com.bookdetails.bookdetails.repository;

import com.bookdetails.bookdetails.model.AuthorInfo;
import com.bookdetails.bookdetails.model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MySqlRespoAuth extends JpaRepository<AuthorInfo,Integer>{
    Optional<AuthorInfo> findByLastName(String lastName);
}
