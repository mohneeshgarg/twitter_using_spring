package com.group4.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class TwitterApplication {


	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

}
