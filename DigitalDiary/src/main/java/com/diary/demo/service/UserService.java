package com.diary.demo.service;




import org.springframework.security.core.userdetails.UserDetailsService;

import com.diary.demo.dto.UserRegistrationDto;
import com.diary.demo.model.User;

public interface UserService extends UserDetailsService {
	 User findByEmail(String email);
	   User save(UserRegistrationDto registration);

}
