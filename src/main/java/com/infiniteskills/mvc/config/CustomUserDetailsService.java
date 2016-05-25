/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.config;

/**
 *
 * @author соколов
 */

import com.infiniteskills.mvc.entity.User;
import com.infiniteskills.mvc.entity.UserRoles;

import com.infiniteskills.mvc.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userService; 

    
 @Override
 @Transactional(readOnly=true)
   public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		com.infiniteskills.mvc.entity.User user = userService.findUserByLogin(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
		
	}
    
    // Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(com.infiniteskills.mvc.entity.User user, 
		List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
    
    
    private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRoles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}


}
