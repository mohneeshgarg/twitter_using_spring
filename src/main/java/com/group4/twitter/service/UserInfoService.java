package com.group4.twitter.service;

import com.group4.twitter.dao.UserInfoDAO;
import com.group4.twitter.entity.UserInfo;
import com.group4.twitter.entity.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService implements UserDetailsService{
	
	@Autowired
	private UserInfoDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = dao.findUserByUsername(username);
		System.out.println("User in service layer: "+user);
		if(user == null) {
			throw new UsernameNotFoundException("This user does not exist");
		}
		return new UserInfoDetails(user);
	}
	
}
