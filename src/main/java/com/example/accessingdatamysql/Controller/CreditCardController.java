package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Classes.CreditCard;
import com.example.accessingdatamysql.Repositories.CreditCardRepository;
import com.example.accessingdatamysql.Classes.User;
import com.example.accessingdatamysql.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/card") // This means URL's start with /user (after Application path)
public class CreditCardController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private CreditCardRepository cardRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addCardForUser (@RequestParam String name,
		@RequestParam String username, @RequestParam Integer number,
		@RequestParam String password, @RequestParam String email,
		@RequestParam String address, @RequestParam String expiration) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		if(!(userRepository.findByName(username).isPresent())) {
			return "User does not exist";
		}
		User n = userRepository.findByName(username).get();
		if(!password.equals(n.getPassword())){
			return "incorrect password";
		}
		CreditCard card = new CreditCard();
		card.setUsername(username);
		card.setName(name);
		card.setAddress(address);
		card.setExpiration(expiration);
		card.setNumber(number);
		cardRepository.save(card);
		return "updated";
	}

	@DeleteMapping(path="/remove") // Map ONLY POST Requests
	public @ResponseBody String removeCard (@RequestParam Integer id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		cardRepository.deleteById(id);
		return "removed";
	}

	@DeleteMapping(path="/removeAll") // Map ONLY POST Requests
	public @ResponseBody String removeAllUsers () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		cardRepository.deleteAll();
		return "removed all entries";
	}
	@DeleteMapping(path="/removeAllFrom") // Map ONLY POST Requests
	public @ResponseBody String removeAllFrom (@RequestParam String username) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		cardRepository.deleteAll(cardRepository.findAllByUsername(username));
		return "removed all entries";
	}

	@PutMapping(path="/update") // Map ONLY POST Requests
	public @ResponseBody String updateCardForUser (@RequestParam String name,
		@RequestParam Integer id,
		@RequestParam String username, @RequestParam Integer number,
		@RequestParam String password, @RequestParam String email,
		@RequestParam String address, @RequestParam String expiration) {
		if(!(userRepository.findByName(username).isPresent())) {
			return "Admin name does not exist";
		}
		User n = userRepository.findByName(username).get();
		if(!password.equals(n.getPassword())){
			return "incorrect password";
		}
		CreditCard card =  cardRepository.findById(id).get();
		card.setUsername(username);
		card.setName(name);
		card.setAddress(address);
		card.setExpiration(expiration);
		card.setNumber(number);
		cardRepository.save(card);
		return "updated";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<CreditCard> getAllUsers() {
		// This returns a JSON or XML with the users
		return cardRepository.findAll();
	}
	@GetMapping(path="/allFrom")
	public @ResponseBody Iterable<CreditCard> getAllUsers(@RequestParam String username) {
		// This returns a JSON or XML with the users
		return cardRepository.findAllByUsername(username);
	}
}
