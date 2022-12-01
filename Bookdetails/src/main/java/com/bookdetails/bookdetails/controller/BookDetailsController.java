package com.bookdetails.bookdetails.controller;

import com.bookdetails.bookdetails.model.AuthorInfo;
import com.bookdetails.bookdetails.model.BookInfo;
import com.bookdetails.bookdetails.repository.MySqlRepository;
import com.bookdetails.bookdetails.repository.MySqlRespoAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookDetailsController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-books")
    public List<BookInfo> getAllBookInfo(){

        return mySqlRepository.findAll();

    }

    @GetMapping("/get-book/{id}")
    public BookInfo getSingleBook(@PathVariable("id") Integer id){
        return mySqlRepository.findById(id).get();
    }


    @GetMapping("/get-book/isbn/{isbn}")
    public BookInfo getSingleBook(@PathVariable String isbn){
        return mySqlRepository.findByIsbn(isbn).get();
    }

   /* @GetMapping ("/books/ISBN/{isbn}")
    List <BookInfo> getBookByIsbn (@PathVariable String isbn) {
       // List <BookInfo> books = BookInfo.GetAllBooks();
        List <BookInfo> isbnBooks = new ArrayList<BookInfo>();
        for (BookInfo b : books) {
            if (b.getIsbn ().equalsIgnoreCase (isbn)) {
                isbnBooks.add(b);
            }
        }
        return isbnBooks;
    }
*/

    @DeleteMapping("/remove-book/{id}")
    public boolean deleteRow(@PathVariable("id") Integer id){
        if(!mySqlRepository.findById(id).equals(Optional.empty())){
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public BookInfo updateBookInfo(@PathVariable("id") Integer id,
                                   @RequestBody Map<String, String> body){

        BookInfo current = mySqlRepository.findById(id).get();
        current.setIsbn(body.get("isbn"));
        current.setTitle(body.get("title"));
        current.setAuthor(body.get("author"));
        current.setDescription(body.get("description"));
        current.setPrice(Integer.parseInt(body.get("price")));
        current.setGenre(body.get("genre"));
        current.setPublisher(body.get("publisher"));
        current.setYearPublished(Integer.parseInt(body.get("YearPublished")));
        current.setCopiesSold(Integer.parseInt(body.get("CopiesSold")));


        mySqlRepository.save(current);
        return current;
    }

    @PostMapping("/add-book")
    public BookInfo create(@RequestBody Map<String, String> body){

        String isbn = body.get("isbn");
        String title = body.get("title");
        String author = body.get("author");
        String description = body.get("description");
        Integer price = Integer.parseInt(body.get("price"));
        String genre = body.get("genre");
        String publisher = body.get("publisher");
        Integer yearPublished = Integer.parseInt(body.get("YearPublished"));
        Integer copiesSold = Integer.parseInt(body.get("CopiesSold"));

        BookInfo newBook = new BookInfo(isbn,title,author,description,price,genre,publisher,yearPublished,copiesSold);

        return mySqlRepository.save(newBook);

    }



}
