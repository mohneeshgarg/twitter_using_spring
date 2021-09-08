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
import org.springframework.ui.Model;
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
    public String openMessagePage(Model m){
//        ModelAndView mv = new ModelAndView("messages");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
//        String url = "http://localhost:8085/user/"+user.getId()+"/";
//        String sentMessages = restTemplate.getForObject(url+"message/sent", String.class);
//        String receivedMessages = restTemplate.getForObject(url+"message/received",  String.class);
//        System.out.println(sentMessages);
//        System.out.println(receivedMessages);
        List<Message> sentMessages = messageService.findSentMessages(user.getId());
        List<Message> receivedMessages = messageService.findReceivedMessages(user.getId());
        m.addAttribute("id", user.getId());
        m.addAttribute("sent", sentMessages);
        m.addAttribute("received", receivedMessages);
        System.out.println(sentMessages);
        System.out.println(receivedMessages);
        return "messages";
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
//        String url = "http://localhost:8085/messages/new";
//        System.out.println(url);
//        String msg = restTemplate.postForObject(url, message ,String.class);
        Date current_date = new Date();
        message.setDate(current_date);
        message.setTime(current_date);
        messageService.insert(message);
        System.out.println("Message Created!");
        return "redirect:/";
    }
}
