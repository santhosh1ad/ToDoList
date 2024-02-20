package com.example.pratice.Securityconfig;
import java.util.*;
import java.util.Collection;
import java.util.List;
//import java.util.*;
import java.util.stream.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pratice.Tables.Details;


public class UserInfoDetails implements UserDetails{
	
	private String Name;
	private String pass;
	private List<GrantedAuthority> Roles;
	public UserInfoDetails(Details user) {
		Name = user.getName();
		pass = user.getPass();
		Roles = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		
	}
	
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}