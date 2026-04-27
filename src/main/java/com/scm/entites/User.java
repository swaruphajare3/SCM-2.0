package com.scm.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    private String userId;
    
    @Column(name = "users_name", nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String password;
    
    @Column(length = 1000)
    private String about;
    
    @Column(length = 1000)
    private String profilePic;
    
    @Column(nullable = true)
    private String phoneNumber;
    
    // information
    private boolean emailVerified = true;
    
    private boolean phoneVerified = false;
    
    private boolean enable = true;
    
    // self, google, GITHUB
   // @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF; 
    
    private String providerId;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<Contact>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public User(String userId, String name, String email, String password, String about, String profilePic,
			String phoneNumber, boolean emailVerified, boolean phoneVerified, boolean enable, Providers provider,
			String providerId, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.profilePic = profilePic;
		this.phoneNumber = phoneNumber;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		this.enable = enable;
		this.provider = provider;
		this.providerId = providerId;
		this.contacts = contacts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roleList=new ArrayList<String>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
		// TODO Auto-generated method st
//	Collection<SimpleGrantedAuthority> roles=roleList.stream().map(role ->new SimpleGrantedAuthority(role)).collect(Collections.tolist());
//		return roles;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
		
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public  boolean isEnabled() {
		return true;
	}
    
}
