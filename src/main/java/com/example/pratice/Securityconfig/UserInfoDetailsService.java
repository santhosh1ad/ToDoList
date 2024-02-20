package com.example.pratice.Securityconfig;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.pratice.Repository.User_Repo;
import com.example.pratice.Tables.*;

public class UserInfoDetailsService implements UserDetailsService {
	
	@Autowired
	private User_Repo repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Details> user = repo.findByName(username);
		return user.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
	}

}
