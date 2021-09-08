package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Tweet;
import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class TweetsController {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/tweet/new")
    public ModelAndView newTweet(){
        return new ModelAndView("newTweet");
    }

    @GetMapping("/tweet/save")
    public String saveTweet(@RequestParam(name = "tweet") String body){
        Date timeStamp = new Date();
        Tweet tweet = new Tweet();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        tweet.setOwnerID(user.getId());
        tweet.setBody(body);
        tweet.setDate(timeStamp);
        tweet.setTime(timeStamp);
        tweetService.insert(tweet);
        return "redirect:/";
    }
}