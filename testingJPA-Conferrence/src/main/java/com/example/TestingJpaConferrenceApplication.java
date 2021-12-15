package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;

//@SpringBootApplication
public class TestingJpaConferrenceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TestingJpaConferrenceApplication.class, args);
		
		SpeakerService speakerService = new SpeakerServiceImpl();
		
		
		System.out.println(speakerService.findAll().get(0).getName());
	}

}
