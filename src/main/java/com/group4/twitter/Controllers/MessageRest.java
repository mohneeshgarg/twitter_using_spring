package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Message;
import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class MessageRest {
    @Autowired
    MessageService messageService;
    @Autowired
    UserDAO userDAO;

    @GetMapping("/home2")
    public String test(){
        return "Its working.";
    }

    @GetMapping("/user/{id}/message/sent")
    public List<Message> getSentMessages(@PathVariable("id") int senderId){
        System.out.println("This is hitted");
        List<Message> sentList = messageService.findSentMessages(senderId);
        System.out.println(sentList);
        return sentList;
    }

    @GetMapping("/user/{id}/message/received")
    public List<Message> getReceivedMessages(@PathVariable("id") int receiverId){
        return messageService.findReceivedMessages(receiverId);
    }

    @PostMapping("/messages/new")
    public String newMessage(Message message){
        System.out.println("We hit this");
        Date current_date = new Date();
        message.setDate(current_date);
        message.setTime(current_date);
        messageService.insert(message);
        return "Message Created";
    }
}
