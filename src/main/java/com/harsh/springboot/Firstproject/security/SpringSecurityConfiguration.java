package com.harsh.springboot.Firstproject.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	//use LDAP or database
	//in memory
	Function<String, String> passwordEncoder= input -> passwordEncoder().encode(input);
	@Bean
	public InMemoryUserDetailsManager createuserdetailmanager() {
		UserDetails userdetails=User.builder()
					.passwordEncoder(passwordEncoder)
					.username("Harsh")
					.password("dummy")
					.roles("user","admin")
					.build();
		return new InMemoryUserDetailsManager(userdetails);
	}
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
}
