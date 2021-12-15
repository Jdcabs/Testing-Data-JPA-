package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Speaker;

public class HibernateRepositoryImp implements SpeakerRepository {

	
	@Override
	public List<Speaker> findAll() {
		
		List<Speaker> speakers = new  ArrayList<Speaker>();
		
		Speaker speaker = new Speaker();
		
		speaker.setName("John David");
		speaker.setLastName("Cabal");
		
		speakers.add(speaker);
		
		return speakers;
	}
}
