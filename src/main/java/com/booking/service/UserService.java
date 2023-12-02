package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entities.User;
import com.booking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;	
	
	public List<User>  getAllConsultant()
	{
		 List<User> consults = userRepo.findAllConsultant();
		 return consults;
	}
	
	public void createUser(User user)
	{
		this.userRepo.save(user);
	}

}
