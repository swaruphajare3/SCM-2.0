package com.scm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entites.User;
import com.scm.helper.Helper;
import com.scm.services.UserSevices;

@ControllerAdvice
public class RootController {
	@Autowired
	UserSevices userSevices;
	

	Logger logger2=	LoggerFactory.getLogger(UserController.class);	

	@ModelAttribute
	public void addLoggedInUserInformat(Model model,Authentication authentication) {
		if(authentication==null) {
			return;
		}
		System.out.println("Adding loggined user information to model");
		String email = Helper.getEmailOfLoggedInUser(authentication);	
		logger2.info("User Logged in:{}",email);
		
		User user=userSevices.getUserByEmail(email);
		
		System.out.println(user);
		
		
		model.addAttribute("loginUser",user); 		
		logger2.info(user.getEmail());
		logger2.info(user.getName());
		
	}

}
