package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.User;
import com.assignment.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public String checkLogin(User user) {
		List<User> list=repo.findAll();
		for (User obj : list) {
			if(obj.getEmail()==user.getEmail() && obj.getPassword()==user.getPassword()) {
				return "Login Successful";
			}
		}
		 return "Login Unsuccessful";	 
    }
//	
//	public User fetchEmailId(String email) {
//		return repo.findByEmailId(email);
//	}
//	

}
