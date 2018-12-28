package com.ck.config;

import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ck.domain.App_roles;
import com.ck.domain.App_users;
import com.ck.repository.RoleRepository;
import com.ck.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new App_roles("ROLE_ADMIN"));
		}
		
		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			roleRepository.save(new App_roles("ROLE_MEMBER"));
		}
		
		// Admin account
		if (userRepository.findByUsername("admin") == null) {
			App_users admin = new App_users();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("123456"));
			HashSet<App_roles> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
		// Member account
		if (userRepository.findByUsername("member") == null) {
			App_users user = new App_users();
			user.setUsername("member");
			user.setPassword(passwordEncoder.encode("123456"));
			HashSet<App_roles> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			user.setRoles(roles);
			userRepository.save(user);
		}
	}

}
