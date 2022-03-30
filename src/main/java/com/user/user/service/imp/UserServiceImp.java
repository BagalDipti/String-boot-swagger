package com.user.user.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.user.dao.UserRepository;
import com.user.user.entities.User;
import com.user.user.service.UserService;


@Service
public class UserServiceImp implements UserService {
	
	
	 @Autowired
	 private UserRepository userRepository;
	 

	 // ----------for view Records---------------------------------------------
	 @Override
	 public List<User> getAllUsers(){
	 List<User> list=(List<User>)this.userRepository.findAll();
	 return list;
	    }
	 
	 

	  @Override 
	  public Optional<User> getById(int userId){ 
	  Optional<User> user =null;
	  
	  try{ user = this.userRepository.findById(userId); } catch(Exception e){
	  e.printStackTrace(); } return user; }
	 

	 //------------for create user---------------------------------------------------
	 @Override
	 public User addUser(User u){

	        User record=userRepository.save(u);
	        return record;
	    }
	 
	 
	 @Override
	 public void updateUser(User user, int userId){
	        user.setUserId(userId);
	        userRepository.save(user);

	    }





	@Override
	public void deleteById(Integer userId) {
    userRepository.deleteById(userId);		
	}


	
	 


}
