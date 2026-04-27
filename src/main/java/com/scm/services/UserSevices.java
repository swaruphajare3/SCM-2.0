package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entites.User;

public interface UserSevices {
	User saveUser(User user);
	Optional<User> getUserById(String id);
	Optional updateUser(User user);
	void deleteUser(String id);
	boolean isUserExist(String 	userId);
	boolean isUserExistbyEmail(String email);
	List<User> getAllUser();
	
	User getUserByEmail(String email);
	
	
	
}
