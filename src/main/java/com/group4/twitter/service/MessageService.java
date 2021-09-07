package com.group4.twitter.service;

import com.group4.twitter.dao.MessageDAO;
import com.group4.twitter.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageDAO dao;

    public List<Message> getAll(){
        return dao.findAll();
    }

    public void insert(Message message){
        dao.save(message);
        System.out.println("New message: "+message);
    }

    public Message findById(int id){
        return dao.findById(id).get();
    }

    public List<Message> findSentMessages(String sender_email){
        return dao.findSentMessages(sender_email);
    }

    public List<Message> findReceivedMessages(String receiver_email){
        return dao.findReceivedMessages(receiver_email);
    }
}
