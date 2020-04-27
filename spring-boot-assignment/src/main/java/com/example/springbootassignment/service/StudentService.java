package com.example.springbootassignment.service;

import java.util.List;

import com.example.springbootassignment.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int stdId);
	
	public Student save(Student stdId);
	
	public void deleteById(int stdId);

}
