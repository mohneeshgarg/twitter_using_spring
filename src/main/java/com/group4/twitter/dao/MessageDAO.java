package com.group4.twitter.dao;

import com.group4.twitter.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageDAO extends JpaRepository<Message, Integer> {

    @Query(value="SELECT m FROM twitter_message m WHERE m.sender_email = :sender_email", nativeQuery = true)
    List<Message> findSentMessages(@Param("sender_email") String sender_email);

    @Query(value="SELECT m FROM twitter_message m WHERE m.receiver_email = :receiver_email", nativeQuery = true)
    List<Message> findReceivedMessages(@Param("receiver_email")String receiver_email);


}
