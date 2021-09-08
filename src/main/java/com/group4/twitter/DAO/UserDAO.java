package com.group4.twitter.DAO;

import com.group4.twitter.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
