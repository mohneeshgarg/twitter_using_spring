package com.group4.twitter.controller;

import com.group4.twitter.entity.Tweet;
import com.group4.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetsController {

    @Autowired
    TweetService tweetService;
    
    @GetMapping("/home")
    public String test(){
        return "Its working.";
    }

    @GetMapping("/user/{id}/tweets")
    public List<Tweet> tweetsByUser(@PathVariable int id){
        return tweetService.findByOwner(id);
    }

    @GetMapping("/tweets/all")
    public List<Tweet> allTweets(){
        return tweetService.getAllTweets();
    }

    @PostMapping("/tweet/add")
    public String addTweet(@RequestBody Tweet tweet){
        return tweetService.insert(tweet);
    }

    @PostMapping("/tweet/{id}/delete")
    public String deleteTweet(@PathVariable int id){
        return tweetService.delete(id);
    }

}
