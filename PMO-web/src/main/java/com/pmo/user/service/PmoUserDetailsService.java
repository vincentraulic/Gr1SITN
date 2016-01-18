package com.pmo.user.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;

public class PmoUserDetailsService implements UserDetailsService{

	private UserDao userDao;

	public PmoUserDetailsService() {
		try {
			InitialContext ctx = new InitialContext();
			userDao = (UserDao) ctx.lookup("java:module/pmo/UserDao");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Employee user = userDao.getUser(username);

		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(Employee user, 
			List<GrantedAuthority> authorities) {
		
		return new UserPmo(user.getUsername(), 
				user.getPassword(), 
				true, true, true, true, 
				authorities, 
				user.getFirstname(), 
				user.getLastname());
	}

	private List<GrantedAuthority> buildUserAuthority(String userRoles) {

		String roles[] = userRoles.split(";");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (String userRole : roles) {
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}


}
