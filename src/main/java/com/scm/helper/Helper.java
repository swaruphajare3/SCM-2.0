package com.scm.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class Helper {

	Logger logger = LoggerFactory.getLogger(Helper.class);

	public static String getEmailOfLoggedInUser(Authentication authentication) {

		if (authentication instanceof OAuth2AuthenticationToken)  {
			var oauth2AutherizationToken = (OAuth2AuthenticationToken) authentication;
			String outhrizationClientRegId = oauth2AutherizationToken.getAuthorizedClientRegistrationId();
			DefaultOAuth2User user=(DefaultOAuth2User) authentication.getPrincipal();
			
			String email="";
			if (outhrizationClientRegId.equalsIgnoreCase("google")) {
				System.out.println("Getting email from google");
				email=user.getAttribute("email").toString();

			} else if (outhrizationClientRegId.equalsIgnoreCase("github")) {
				System.out.println("Getting email from github");
				
				 email=user.getAttribute("email") !=null ?
						user.getAttribute("email").toString() : user.getAttribute("login").toString() +"@gmail.com";

			}
			return email;
		}else {
			System.out.println("Getting email from Local database");
			
		}
		return authentication.getName();

		
	}
}
