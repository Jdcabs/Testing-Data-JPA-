package com.example.service;

import java.util.List;

import com.example.model.Speaker;
import com.example.repository.HibernateRepositoryImp;
import com.example.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository = new HibernateRepositoryImp();
	
	@Override
	public List<Speaker> findAll() {
		return repository.findAll();
	}
}
