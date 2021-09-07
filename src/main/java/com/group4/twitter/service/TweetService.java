package com.group4.twitter.service;

import com.group4.twitter.dao.TweetDAO;
import com.group4.twitter.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetDAO dao;

    public List<Tweet> getAllTweets(){
        return dao.findAll();
    }

    public void insert(Tweet tweet){
        dao.save(tweet);
        System.out.println("New tweet: "+tweet);
    }

    public Tweet findById(int id){
        return dao.findById(id).get();
    }

    public List<Tweet> findByEmail(String email){
        return dao.findByEmail(email);
    }

    public void delete(int id){
        Tweet tweet = findById(id);
        dao.delete(tweet);
        System.out.println("Deleted tweet: "+tweet);
    }

    public void deleteAll(){
        dao.deleteAll();
        System.out.println("Deleted all tweets");
    }
}
