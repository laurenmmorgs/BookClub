package com.laurenmorgan.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.laurenmorgan.bookClub.models.LoginUser;
import com.laurenmorgan.bookClub.models.User;
import com.laurenmorgan.bookClub.repositories.UserRepository;

@Service
public class UserService {
	
	 	@Autowired
	    private UserRepository userRepo;
	    
	   
	    public User register(User newUser, BindingResult result) {
	       
	    	// TO-DO - Reject values or register if no errors:
	    	
	    	// Reject if email is taken (present in database)
	    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
	    	
	    	
	    	if(potentialUser.isPresent()) {
	    		result.rejectValue("email", "email", "This email already exists");
	    		return null;
	    	}
	    	// Reject if password doesn't match confirmation
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    	    return null;
	    	}
	        
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	System.out.println(hashed);
	    	
	        // Return null if result has errors
	    	newUser.setPassword(hashed);

	        // Hash and set password, save user to database
	        return userRepo.save(newUser);
	        

	    }

	    
	    
	    public User login(LoginUser newLoginObject, BindingResult result) {
	       
	    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
	    	
	    	if(!potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    	
	    	User user = potentialUser.get();
	        
	    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	
	    	if(result.hasErrors()) {
	        	return null;
	        }

	    	return user;
	    }
	    
	    
	    
	    
	    
	    public List<User> allUsers() {
	        return userRepo.findAll();
	    }

	    public User createOrUpdate(User user) {
	        return userRepo.save(user);
	    }

	    public User findOne(Long id) {
	        Optional<User> optionalUser = userRepo.findById(id);
	        if(optionalUser.isPresent()) {
	            return optionalUser.get();
	        } else {
	            return null;
	        }
	    }
	
	    
	    

}
