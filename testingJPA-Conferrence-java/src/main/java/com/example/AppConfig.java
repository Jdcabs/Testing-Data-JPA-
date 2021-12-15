package com.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.repository.HibernateRepositoryImp;
import com.example.repository.SpeakerRepository;
import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;

@Configuration

public class AppConfig {
	
	@Scope(value = BeanDefinition.SCOPE_SINGLETON)
	@Bean(name = "speakerService")
	public SpeakerService getSpeakerService() {
		SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
		//service.setRepository(getSpeakerRepository());
		return service;
	}
	
	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new HibernateRepositoryImp();
	}
}
