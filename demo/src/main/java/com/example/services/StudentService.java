package com.example.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.Student;

@Service
@Component
public class StudentService {
	
	public List<Student> getStudent() {
		return List.of(
				new Student(1L, "david", 21, LocalDate.of(1999, 10, 05), "@gmail.com")
				);
	}
}
