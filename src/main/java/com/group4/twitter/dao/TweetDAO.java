package com.group4.twitter.dao;

import com.group4.twitter.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetDAO extends JpaRepository<Tweet, Integer> {

    @Query(value="SELECT * FROM twitter_tweet WHERE owner_id = :owner_id", nativeQuery = true)
    List<Tweet> findByOwner(@Param("owner_id") int owner_email);
}
