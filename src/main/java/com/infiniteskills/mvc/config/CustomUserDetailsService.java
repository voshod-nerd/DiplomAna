/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.config;

import com.infiniteskills.mvc.entity.Employee;
import com.infiniteskills.mvc.entity.UserRoles;
import com.infiniteskills.mvc.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author соколов
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
        
        @Autowired
	private UserRepository userService;
	
        
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Employee user = userService.findUserByLogin(userName);   
                System.out.println(user.getUsername()); 
                System.out.println(user.getPassword());
                System.out.println(user.getRole());
                
                List<String> ls= userService.getAllRoles();
                 System.out.println(ls.size());
                
		if(user == null){
                   
			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
                
                
                List<GrantedAuthority> authorities = buildUserAuthority(userService.getAllRoles());
		//return new SecurityUser(user);
                 
             return buildUserForAuthentication(user, authorities);
	}
        
        
        // Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.infiniteskills.mvc.entity.Employee user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Collection<String> userRoles) {
                
                 System.out.println("2f");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
             
		// Build user's authorities
		for (String userRole : userRoles) {
                        System.out.println(userRole);
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
        
}
