 package com.scm.servises.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.repsitories.UserRepo;

@Service
public class CustomSecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		return repo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with this email Id")); 
	}
	
	

}
