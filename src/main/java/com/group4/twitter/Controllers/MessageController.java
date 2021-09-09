package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Message;
import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.MessageService;
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

import java.util.Date;
import java.util.List;

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

    @Autowired
    MessageService messageService;
    @RequestMapping("/messages")
    public ModelAndView openMessagePage(){
        ModelAndView mv = new ModelAndView("messages");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        List<Message> sentMessages = messageService.findSentMessages(user.getId());
        List<Message> receivedMessages = messageService.findReceivedMessages(user.getId());
        mv.addObject("id", user.getId());
        mv.addObject("sent", sentMessages);
        mv.addObject("received", receivedMessages);
        System.out.println(sentMessages);
        System.out.println(receivedMessages);
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
        User fromUser = userDAO.findById(id).get();
        Date current_date = new Date();
        Message message = new Message(messageBody, id, toUser.getId(), fromUser.getName(), toUser.getName(), current_date, current_date);
        System.out.println(toUser.getName());
        messageService.insert(message);
        System.out.println(message);
        System.out.println("Message Created!");
        return "redirect:/";
    }
}
