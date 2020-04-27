package com.example.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootassignment.dao.CoursesRepository;
import com.example.springbootassignment.entity.Course;

@Service
public class CourseServiceImplementation implements CourseService {

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Override
	public List<Course> findAll() {

		return coursesRepository.findAll();
	}

	@Override
	public Course findById(int cId) {
		Optional<Course> theCourse=coursesRepository.findById(cId);
		Course theCourse2=null;
		if(theCourse.isPresent())
		{
			theCourse2=theCourse.get();
		}
		else
		{
			throw new RuntimeException("Course with id "+cId+" Not found ");
		}
		return theCourse2;
	}

	@Override
	public Course save(Course cId) {
		Course theCourse=coursesRepository.save(cId);
		return theCourse;
	}

	@Override
	public void deleteById(int cId) {
		coursesRepository.deleteById(cId);
	}

}
