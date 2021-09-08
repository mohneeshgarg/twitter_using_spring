package com.group4.twitter.controller;

import com.group4.twitter.entity.Message;
import com.group4.twitter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    MessageService messageService;

    @GetMapping("/home2")
    public String test(){
        return "Its working.";
    }

    @GetMapping("/user/{id}/message/sent")
    public List<Message> getSentMessages(@PathVariable("id") int senderId){
        return messageService.findSentMessages(senderId);
    }

    @GetMapping("/user/{id}/message/received")
    public List<Message> getReceivedMessages(@PathVariable("id") int receiverId){
        return messageService.findReceivedMessages(receiverId);
    }

    @PostMapping("user/message/new")
    public void newMessage(@RequestBody Message message){
        Date current_date = new Date();
        message.setDate(current_date);
        message.setTime(current_date);
        messageService.insert(message);
    }

}
