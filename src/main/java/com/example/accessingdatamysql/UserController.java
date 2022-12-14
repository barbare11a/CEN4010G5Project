package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class  UserController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email, @RequestParam Integer value) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setValue(value);
		userRepository.save(n);
		return "saved";
	}

	@DeleteMapping(path="/remove") // Map ONLY POST Requests
	public @ResponseBody String removeUser (@RequestParam Integer id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		userRepository.deleteById(id);
		return "removed";
	}

	@DeleteMapping(path="/removeAll") // Map ONLY POST Requests
	public @ResponseBody String removeAllUsers () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		userRepository.deleteAll();
		return "removed all entries";
	}

	@PutMapping(path="/update") // Map ONLY POST Requests
	public @ResponseBody String updateUser (@RequestParam String name
			, @RequestParam String email, @RequestParam Integer value) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		User n = userRepository.findById(value).get();
		n.setName(name);
		n.setEmail(email);
		n.setValue(value);
		userRepository.save(n);
		return "updated";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
