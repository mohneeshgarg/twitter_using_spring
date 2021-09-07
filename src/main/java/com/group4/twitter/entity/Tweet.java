package com.group4.twitter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="twitter_tweet")
public class Tweet {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int tweetId;

    @Column
    private String text;

    @Column
    private String owner_email;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date time;

    public Tweet() {};

    public Tweet(int tweetId, String text, String owner_email, Date date, Date time) {
        this.tweetId = tweetId;
        this.text = text;
        this.owner_email = owner_email;
        this.date = date;
        this.time = time;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
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
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", text='" + text + '\'' +
                ", owner_email='" + owner_email + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
