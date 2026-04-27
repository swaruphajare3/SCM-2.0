package com.scm.config;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.entites.Providers;
import com.scm.entites.User;
import com.scm.helper.AppConstant;
import com.scm.repsitories.UserRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UserRepo repo;

	Logger logger = LoggerFactory.getLogger(OAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		logger.info("OAuthenticationSuccessHandler");
		
	var oauth2AutherizationToken=(OAuth2AuthenticationToken)authentication;
	
	String outhrizationClientRegId=oauth2AutherizationToken.getAuthorizedClientRegistrationId();
	logger.info(outhrizationClientRegId);
	DefaultOAuth2User user=(DefaultOAuth2User) authentication.getPrincipal();
	//logger.info(user.getName());
	user.getAttributes().forEach((key,value) ->{
		logger.info("{} => {}",key,value);
	});
	
	User user2=new User();
	user2.setUserId(UUID.randomUUID().toString());
	user2.setRoleList(List.of(AppConstant.ROLE_USER));
	user2.setEnable(true);
	
	
	if(outhrizationClientRegId.equalsIgnoreCase("google")) {
		
		user2.setEmail(user.getAttribute("email").toString());
		user2.setName(user.getAttribute("name").toString());
		user2.setProfilePic(user.getAttribute("picture").toString());
		user2.setEmailVerified(user.getAttribute("email_verified"));
		user2.setProviderId(user.getName());
		user2.setProvider(Providers.GOOGLE);
		user2.setAbout("Login with Google");
		
		
	}else if (outhrizationClientRegId.equalsIgnoreCase("github")) {
		
		String email=user.getAttribute("email") !=null ?
				user.getAttribute("email").toString() : user.getAttribute("login").toString() +"@gmail.com";
		String picString= user.getAttribute("avatar_url").toString();
		String name=user.getAttribute("login").toString();
		String providerId=user.getName().toString();
		
		user2.setProvider(Providers.GITHUB);
		user2.setProviderId(providerId);
		user2.setName(name);
		user2.setProfilePic(picString);
		user2.setEmail(email);
		
		user2.setAbout("Login with github");
		
		
		
		
		
	}
//		
//		DefaultOAuth2User user=(DefaultOAuth2User) authentication.getPrincipal();
//		logger.info(user.getName());
//		user.getAttributes().forEach((key,value) ->{
//			logger.info("{} => {}",key,value);
//		});
//		
//		logger.info(user.getAuthorities().toString());
//		
//		String email =user.getAttribute("email").toString();
//		System.out.println(email);
//		String name= user.getAttribute("name").toString();
//		String picture=user.getAttribute("picture").toString();
//		
//		
//		User user2=new User();
//		user2.setEmail(email);
//		user2.setProfilePic(picture);
//		user2.setName(name);
//		user2.setPassword("Password");
//		user2.setUserId(UUID.randomUUID().toString());
//		user2.setProvider(Providers.GOOGLE);
//		user2.setEmailVerified(true);
//		user2.setEnable(false);
//		user2.setProviderId(user.getName());
//		user2.setRoleList(List.of(AppConstant.ROLE_USER));
//		user2.setAbout("This accout is created using google");
//		user2.setPhoneNumber("112423547");
//		
			User user3=repo.findByEmail(user2.getEmail()).orElse(null);
			
			if(user3==null) {
				repo.save(user2);
				
			}
		
			

		new DefaultRedirectStrategy().sendRedirect(request, response, "/user/profile");

	}

}
