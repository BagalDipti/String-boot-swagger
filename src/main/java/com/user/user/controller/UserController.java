package com.user.user.controller;

import java.util.List;
import java.util.Optional;

import com.user.user.entities.User;
import com.user.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// -------------- Get All Users-----------------------------------------------------------------
	@GetMapping("/all")

	public ResponseEntity<List<User>> getUser() {

		List<User> list = userService.getAllUsers();
		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// ------------- get single User handler--------------------------------------------------

	@GetMapping("/{userId}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable("userId") int userId) {
		Optional<User> user = userService.getById(userId);

		if (user == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}

	// ------------------ Create new user-----------------------------------------------------

	@PostMapping("/addusers")

	public ResponseEntity<User> addUser(@RequestBody User user) {
		User u = null;
		try {
			u = this.userService.addUser(user);
			return ResponseEntity.of(Optional.of(u));
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// ---------------Update User---------------------------------------------------------------

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId) {

		try {
			this.userService.updateUser(user, userId);
			return ResponseEntity.ok().body(user);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//------------------Delete User-----------------------------------------------------
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deteteUser(@PathVariable("userId") int userId){
		try {
			this.userService.deleteById(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(Exception e) {
			
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
	}

}
