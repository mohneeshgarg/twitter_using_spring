package com.group4.twitter.controller;

import com.group4.twitter.entity.Tweet;
import com.group4.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    TweetService tweetService;
    @RequestMapping("/home")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("homepage");
        List<Tweet> allTweets = tweetService.getAllTweets();
        mv.addObject("tweets",allTweets);
        return mv;
    }

    @RequestMapping("/tweet/new")
    public ModelAndView newTweet(){
        return new ModelAndView("newTweetPage");
    }

    @GetMapping("/tweet/save")
    public String saveTweet(@RequestParam(name = "tweet") String body){
        Date timeStamp = new Date();
        Tweet tweet = new Tweet();
        tweet.setOwnerID(2);
        tweet.setBody(body);
        tweet.setDate(timeStamp);
        tweet.setTime(timeStamp);
        tweetService.insert(tweet);
        return "redirect:/home";
    }

}
