package com.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.models.User;
import com.main.repository.UserRepository;
import com.main.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public User createUser(User user) {
		
		User save = userRepository.save(user);
		
		return save;
	}

	@Override
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Founda"));
		userRepository.delete(user);
		
	}

	@Override
	public User updateUser(User user, int id) {
		
		User user1 = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setPhone(user.getPhone());
		User updatedUser = userRepository.save(user1);
		
		
		
		return updatedUser;
	}

	@Override
	public User getSingleUser(int id) {
		
		User getSingleUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
		
		return getSingleUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = userRepository.findAll();
	
		return findAll;
	}

}
