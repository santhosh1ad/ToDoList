package com.example.pratice.Securityconfig;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity

public class Sec_config {

	@Bean
	public UserDetailsService userdetails(PasswordEncoder encoder) {
		return new UserInfoDetailsService();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/Home/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/Home").hasAnyRole("USER","ADMIN")
				.requestMatchers("/Home/**").hasAnyRole("USER","ADMIN")
				.requestMatchers("/Add_user/**").permitAll()

				.anyRequest().authenticated()

		);

		http.formLogin(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(UserDetailsService obj) {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(obj);
		auth.setPasswordEncoder(encoder());
		return auth;
	}

}
