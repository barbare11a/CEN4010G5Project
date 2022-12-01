package com.bookdetails.bookdetails.repository;

import com.bookdetails.bookdetails.model.AuthorInfo;
import com.bookdetails.bookdetails.model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


//public interface MySqlRepository extends CrudRepository<BookInfo,Integer> {}
public interface MySqlRepository extends JpaRepository<BookInfo,Integer>{
    Optional<BookInfo> findByIsbn(String isbn);
}

