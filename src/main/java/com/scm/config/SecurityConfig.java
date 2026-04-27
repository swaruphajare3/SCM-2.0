package com.scm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.scm.servises.imp.CustomSecurityUserDetailsService;



@Configuration
public class SecurityConfig {
	
	@Autowired
	private CustomSecurityUserDetailsService customSecurityUserDetailsService;
	
	@Autowired
	private OAuthenticationSuccessHandler authenticationSuccessHandler;
	
	//Configuration of Authentication Providers
	@Bean
	 public DaoAuthenticationProvider authenticationProvider () {
		
		 DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		 
		 authenticationProvider.setUserDetailsService(customSecurityUserDetailsService);
		 authenticationProvider.setPasswordEncoder(encoder());
		 
		 
		 return authenticationProvider;
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		//url configure
		httpSecurity.authorizeHttpRequests(authorize ->{
			
			authorize.requestMatchers("/user/**").authenticated();
			authorize.anyRequest().permitAll();
			
		});

	   //  httpSecurity.csrf(csrf -> csrf.disable()); 
		httpSecurity.formLogin(fromlogin ->{
			fromlogin.loginPage("/login");
			fromlogin.loginProcessingUrl("/authenticate");
			fromlogin.successForwardUrl("/user/profile");
			fromlogin.failureForwardUrl("/login?error=true");
			fromlogin.usernameParameter("email");
			fromlogin.passwordParameter("password");

		});
		
		httpSecurity.csrf(AbstractHttpConfigurer ::disable);
		httpSecurity.logout(logout ->{
			logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");
		});
		
		
		httpSecurity.oauth2Login(oauth ->{
			oauth.loginPage("/login");		
			oauth.successHandler(authenticationSuccessHandler);		
		});
		
		
		return httpSecurity.build();
		
	}
	
	@Bean
	public  PasswordEncoder encoder() {
		
		
		return new BCryptPasswordEncoder();
		
	}


}
