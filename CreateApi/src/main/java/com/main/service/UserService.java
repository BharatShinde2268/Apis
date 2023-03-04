package com.main.service;

import java.util.List;

import com.main.models.User;

public interface UserService {

	
	// create user method 
	
	public User createUser(User user);
	
	
	// delete user method 
	
	public void deleteUser(int id);
	
	
	// update user method 
	public User updateUser(User user, int id);
	
	
	// get single user method 
	
	public User getSingleUser(int id);
	
	
	
	// get all user method 
	public List<User> getAllUsers();
	
}
