package com.scm.servises.imp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entites.User;
import com.scm.exception.ResourceNotFoundException;
import com.scm.helper.AppConstant;
import com.scm.repsitories.UserRepo;
import com.scm.services.UserSevices;

@Service
public class UserSevicesImp implements UserSevices{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User saveUser(User user) {
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		user.setRoleList(List.of(AppConstant.ROLE_USER));
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(String id) {
		
		
		return userRepo.findById(id);
	}

	@Override
	public Optional updateUser(User user) {
	
		 User user2=userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found")) ;
		 user2.setName(user.getName());
		 user2.setEmail(user.getEmail());
		 user2.setPassword(user.getPassword());
		 user2.setPassword(user.getPhoneNumber());
		 user2.setAbout(user.getAbout());
		 user2.setProfilePic(user.getProfilePic());
		 user2.setEmailVerified(user.isEmailVerified());
		 user2.setPhoneVerified(user.isPhoneVerified());
		 user2.setEnable(user2.isEnable());
		 user2.setProvider(user.getProvider());
		 user2.setProviderId(user.getProviderId());
		 
		 //save in database
		 
		 User save=userRepo.save(user2);
		return Optional.ofNullable(save);
	}

	@Override
	public void deleteUser(String id) {
		User user2= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found")) ;
		 
		userRepo.delete(user2);
		
		
	}

	@Override
	public boolean isUserExist(String userId) {
		User user2= userRepo.findById(userId).orElse(null) ;
		return user2 !=null ? true : false ;
	}

	@Override
	public boolean isUserExistbyEmail(String email) {
	User user	=userRepo.findByEmail(email).orElse(null);
	return user !=null ? true : false ;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email).orElse(null);
	}



}
