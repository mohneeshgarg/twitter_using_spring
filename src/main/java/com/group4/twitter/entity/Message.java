package com.group4.twitter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="twitter_message")
public class Message {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int messageId;

    @Column
    private String body;

    @Column
    private String sender_email;

    @Column
    private String receiver_email;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date time;

    public Message() {};

    public Message(int messageId, String body, String sender_email, String receiver_email, Date date, Date time) {
        this.messageId = messageId;
        this.body = body;
        this.sender_email = sender_email;
        this.receiver_email = receiver_email;
        this.date = date;
        this.time = time;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", body='" + body + '\'' +
                ", sender_email='" + sender_email + '\'' +
                ", receiver_email='" + receiver_email + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
