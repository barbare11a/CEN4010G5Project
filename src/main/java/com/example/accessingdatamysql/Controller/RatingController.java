package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Classes.Book;
import com.example.accessingdatamysql.Classes.Rating;
import com.example.accessingdatamysql.Classes.User;
import com.example.accessingdatamysql.Repositories.RatingRepository;
import com.example.accessingdatamysql.Repositories.UserRepository;
import com.example.accessingdatamysql.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/rating") // This means URL's start with /comment (after Application path)
public class RatingController {
	@Autowired// This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private RatingRepository ratingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewRating (@RequestParam String username,
			@RequestParam String password, @RequestParam String bookName,
			@RequestParam Integer star) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		if(!(userRepository.findByName(username).isPresent())) {
			return "User does not exist";
		}
		User n = userRepository.findByName(username).get();
		if(!password.equals(n.getPassword())){
			return "incorrect password";
		}
		Rating x = new Rating();
		x.setUser(username);
		x.setBook(bookName);
		x.setStar(star);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String dateString = formatter.format(date).toString();
		x.setDate(dateString);
		ratingRepository.save(x);
		return "success";
	}

	@DeleteMapping(path="/remove") // Map ONLY POST Requests
	public @ResponseBody String removeRating (@RequestParam Integer id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		ratingRepository.deleteById(id);
		return "removed";
	}

	@DeleteMapping(path="/removeAll") // Map ONLY POST Requests
	public @ResponseBody String removeAllRatings () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		ratingRepository.deleteAll();
		return "removed all entries";
	}

	@PutMapping(path="/update") // Map ONLY POST Requests
	public @ResponseBody String updateComment (@RequestParam String name,
			@RequestParam Integer star, @RequestParam String book) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Rating n = ratingRepository.findByName(name);
		n.setStar(star);
		ratingRepository.save(n);
		return "updated";
	}

	@GetMapping(path="/allComments")
	public @ResponseBody Iterable<Rating> getAllComments() {
		// This returns a JSON or XML with the users
		return ratingRepository.findAll();
	}

	@GetMapping(path="/allRatings")
	public @ResponseBody Iterable<Rating> getAllOrderedRatings() {
		// This returns a JSON or XML with the users
		return ratingRepository.findAll();
	}

	@GetMapping(path="/rating")
	public @ResponseBody Double getBookRating(@RequestParam String book) {
		Iterable<Rating> ratings = ratingRepository.findAllByBook(book);
		Iterator<Rating> ratingIterator = ratings.iterator();
		Double Stars = 0.0;
		Integer amount = 0;
		while(ratingIterator.hasNext()){
			Rating n = ratingIterator.next();
			Stars += n.getStars();
			amount++;
		}

		return Stars/amount;
	}

	@GetMapping(path="/allRatingsFrom")
	public @ResponseBody Iterable<Rating> getAllRatingsFrom(@RequestParam String username) {
		return ratingRepository.findAllByName(username);
	}

	@GetMapping(path="/ratingFromOrdered")
	public @ResponseBody Iterable<Rating> getOrderedRatings(@RequestParam String bookName) {
		return ratingRepository.findByNameOrderByStar(bookName);
	}
}
