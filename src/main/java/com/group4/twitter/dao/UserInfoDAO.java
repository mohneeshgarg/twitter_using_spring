package com.group4.twitter.dao;

import java.util.Optional;

import com.group4.twitter.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDAO extends JpaRepository<UserInfo, Integer> {
	
	UserInfo findUserByUsername(String username);

}
