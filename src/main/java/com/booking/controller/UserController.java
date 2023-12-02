package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entities.User;
import com.booking.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/consultants")
	public ResponseEntity<List<User>> getAllConsultant()
	{
		List<User> allConsultant = this.userService.getAllConsultant();
		return new ResponseEntity<List<User>>(allConsultant,HttpStatus.OK);		
	}
	
	@PostMapping("/")
	public ResponseEntity<String> createUser(@RequestBody User user)
	{
		this.userService.createUser(user);
		return new ResponseEntity<String>("User created succesfully" , HttpStatus.CREATED);
	}
	
	

}
