package com.example.secapp.secservice;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.secapp.user.User;
import com.example.secapp.user.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public MyUserDetails loadUserByUsername(String username) {
		Supplier<UsernameNotFoundException> supplier = () -> new UsernameNotFoundException("Check your username");

		User u = userRepo.findByUsername(username).orElseThrow(supplier);

		return new MyUserDetails(u);
	}

}
