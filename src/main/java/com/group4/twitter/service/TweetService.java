package com.group4.twitter.service;

import com.group4.twitter.dao.TweetDAO;
import com.group4.twitter.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetDAO dao;

    public List<Tweet> getAllTweets(){
        return dao.findAll();
    }

    public String insert(Tweet tweet){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        dao.save(tweet);
        System.out.println("New tweet: "+tweet);
        return "Successfully added tweet by user: "+tweet.getOwnerID();
    }

    public Tweet findById(int id){
        return dao.findById(id).get();
    }

    public List<Tweet> findByOwner(int ownerId){
        return dao.findByOwner(ownerId);
    }

    public String delete(int id){
        Tweet tweet = findById(id);
        dao.delete(tweet);
        System.out.println("Deleted tweet: "+tweet);
        return "Successfully deleted tweet with id: "+tweet.getTweetId();
    }

    public void deleteAll(){
        dao.deleteAll();
        System.out.println("Deleted all tweets");
    }
}
