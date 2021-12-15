package com.example;

import java.util.Scanner;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;

//@SpringBootApplication
public class TestingJpaConferrenceApplication {

	public static void main(String[] args) {
//SpringApplication.run(TestingJpaConferrenceApplication.class, args);
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//SpeakerService speakerService = new SpeakerServiceImpl();
		
		SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
		
		System.out.println(service);
		
		System.out.println(service.findAll().get(0).getLastName());
		
		SpeakerService service2 = appContext.getBean("speakerService", SpeakerService.class);
		
		System.out.println(service2);
		
	}
}
