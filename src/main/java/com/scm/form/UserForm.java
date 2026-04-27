package com.scm.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserForm {
	
	@NotBlank(message = "Username is Required")
	@Size(min = 3,max = 20,message = "Minimum Three Charector Required")
	private String name;
	
	@Email(message = "Invalid Email Address")	
	@NotBlank(message = "Email is Required")
	private String email;
	
	@NotBlank(message = "Password is Required")
	@Size(min = 6,max = 15,message = "Minimum Six Charector Required")
	private String password;
	
	@NotBlank(message = "About is required")
	private String about;
	
	@Size(min = 8,max = 12, message = "Invalid Phone Number")
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserForm(String name, String email, String password, String about, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.phoneNumber = phoneNumber;
	}
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserForm [name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
