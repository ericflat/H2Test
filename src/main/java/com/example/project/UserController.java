package com.example.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> getUserByID(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserByID(id));
	}
	
	@GetMapping("/{lastname}")
	public ResponseEntity<List<Users>> getUserByID(@PathVariable String lastname) {
		return ResponseEntity.ok(userService.findUserByLastName(lastname));
	}
	

	@PostMapping
	public Users createUser(@RequestBody Users user) {
		return userService.createUser(user);
	}

	@DeleteMapping("/{id}")
	public Boolean deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return true;

	}
	
}
