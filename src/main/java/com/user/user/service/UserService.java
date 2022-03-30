package com.user.user.service;

import java.util.List;
import java.util.Optional;

import com.user.user.entities.*;


public interface UserService{
	
	
	public List<User> getAllUsers();
		
	public User addUser(User user);
	
	public void updateUser(User user, int userId);

	public Optional<User> getById(int userId);

	void deleteById(Integer userId);
	
	//public void deleteById(Integer userId);

	
	
	
}