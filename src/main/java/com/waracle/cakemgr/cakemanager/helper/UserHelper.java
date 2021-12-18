package com.waracle.cakemgr.cakemanager.helper;

import com.waracle.cakemgr.cakemanager.model.User;

public class UserHelper extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	   public UserHelper(User user) {
	      super(
	    		  user.getUsername(),
	    		  user.getPassword(),
	    		  user.getListOfgrantedAuthorities()
	    		);
	   }
}
