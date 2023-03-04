package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.User;
import com.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	// create user 
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user)
	{
		 User createUser = userService.createUser(user);
		 return createUser;
		
	}
 	
	
	// delete user 
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id)
	{
		userService.deleteUser(id);
	}
	
	// update user
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id )
	{
		User updateUser = userService.updateUser(user, id);
		
		
		return updateUser;
	}
	
	
	// get single user 
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable("id") int id)
	{
		
		User singleUser = userService.getSingleUser(id);
		return singleUser;
		
		
	}
	
	
	// get all user
	@GetMapping("/all")
	public List<User> getAll()
	{
		
		List<User> allUsers = userService.getAllUsers();
		return allUsers;
	}
	
	
	
	
}
