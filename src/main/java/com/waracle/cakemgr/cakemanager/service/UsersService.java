package com.waracle.cakemgr.cakemanager.service;

import com.waracle.cakemgr.cakemanager.helper.UserHelper;
import com.waracle.cakemgr.cakemanager.model.User;
import com.waracle.cakemgr.cakemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserHelper loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = getUserDetails(username);
			UserHelper userDetail = new UserHelper(user);
			return userDetail;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
	}

	public User getUserDetails(String username) {
		Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();

		Optional<com.waracle.cakemgr.cakemanager.entity.User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));

		if(userOptional.isPresent()) {
			User userModel = new User();
			userModel.setUsername(userOptional.get().getUsername());
			userModel.setPassword(userOptional.get().getPassword());
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			listOfgrantedAuthorities.add(grantedAuthority);
			userModel.setListOfgrantedAuthorities(listOfgrantedAuthorities);
			return userModel;
		}
		return null;
	}

}
