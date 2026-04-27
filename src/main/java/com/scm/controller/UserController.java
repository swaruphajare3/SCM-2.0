package com.scm.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.scm.entites.User;
import com.scm.helper.Helper;
import com.scm.services.UserSevices;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserSevices userSevices;
	
	Logger logger2=	LoggerFactory.getLogger(UserController.class);
	
	
	
	//user Dashboard page
	@RequestMapping(value = "/dashboard")
	public String userDashboard(Principal principal) {
		 
		String name=principal.getName();
	//	logger.info("User logged in:{}",name);
		
		return "user/dashboard.html";
	}
	
	//user Profile Page
	@RequestMapping(value = "/profile")
	public String userProfile(Model model, Authentication authentication) {	
		
		
		return "user/profile.html";
	}
	
	//user add contacts page
	
	//user view contacts
	
	//user edit contacts
	
	//user delete contacts
	
	//user search contacts
	

}
