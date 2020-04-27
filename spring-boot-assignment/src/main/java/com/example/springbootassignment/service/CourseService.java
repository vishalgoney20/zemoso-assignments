package com.example.springbootassignment.service;

import java.util.List;

import com.example.springbootassignment.entity.Course;


public interface CourseService {
	
	public List<Course> findAll();
	
	public Course findById(int cId);
	
	public Course save(Course cId);
	
	public void deleteById(int cId);

}
