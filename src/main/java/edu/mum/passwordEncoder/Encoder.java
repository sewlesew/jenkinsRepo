package edu.mum.passwordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {	
	
	public String encodePassword(String password){		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
		return passwordEncoder.encode(password);
		
	}

}
