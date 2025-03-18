package com.harsh.springboot.Firstproject.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		boolean samplevalidId = username.equalsIgnoreCase("dummy");
		boolean samplevalidPas= password.equalsIgnoreCase("dummy");
		
		return samplevalidId && samplevalidPas;
	}
}
