package com.group4.twitter.dao;

import com.group4.twitter.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetDAO extends JpaRepository<Tweet, Integer> {

    @Query(value="SELECT t FROM twitter_tweet t WHERE t.owner_email = :owner_email", nativeQuery = true)
    List<Tweet> findByEmail(@Param("owner_email") String owner_email);
}
