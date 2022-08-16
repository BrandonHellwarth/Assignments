package com.BrandonHellwarth.BookClub.Services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.BrandonHellwarth.BookClub.Models.LoginUser;
import com.BrandonHellwarth.BookClub.Models.User;
import com.BrandonHellwarth.BookClub.Repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		Optional<User> potentialUser2 = userRepo.findByUserNameContains(newUser.getUserName());
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already registered to a user.");
		}
		
		if(potentialUser2.isPresent()) {
			result.rejectValue("userName", "Matches", "User name is taken.");
		}
		
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
	
	
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password");
    	}
    	if(result.hasErrors()) {
    		System.out.println("working");
    		return null;
    	}
        return potentialUser.get();
    }
    
    
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
    
    public User findByEmail(String email) {
    	Optional<User> potentialUser = userRepo.findByEmail(email);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
}