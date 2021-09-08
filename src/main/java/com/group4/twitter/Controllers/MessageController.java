package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Message;
import com.group4.twitter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    UserDAO userDAO;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/messages")
    public ModelAndView openMessagePage(){
        ModelAndView mv = new ModelAndView("messages");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        String url = "http://localhost:8085/user/"+user.getId()+"/";
        String sentMessages = restTemplate.getForObject(url+"message/sent", String.class);
        String receivedMessages = restTemplate.getForObject(url+"message/received",  String.class);
//        System.out.println(sentMessages);
//        System.out.println(receivedMessages);
        mv.addObject("id", user.getId());
        mv.addObject("sent", sentMessages);
        mv.addObject("received", receivedMessages);
        return mv;
    }
    @GetMapping("/user/{id}/messages/new")
    public ModelAndView newMessage(@PathVariable int id){
        ModelAndView mv = new ModelAndView("newMessage");
        mv.addObject("id", id);
        return mv;
    }
    @GetMapping("/messages/{id}/new")
    public String addMessage(@PathVariable int id,
                             @RequestParam("messageBody") String messageBody,
                             @RequestParam("receiver") String receiver){
        User toUser = userDAO.findByUserName(receiver);
        Message message = new Message();
        message.setBody(messageBody);
        message.setSenderId(id);
        message.setReceiverId(toUser.getId());
        String url = "http://localhost:8085/messages/new";
        System.out.println(url);
        String msg = restTemplate.postForObject(url, message ,String.class);
        return "redirect:/";
    }
}
