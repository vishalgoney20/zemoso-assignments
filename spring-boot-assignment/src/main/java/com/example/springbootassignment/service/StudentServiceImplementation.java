package com.example.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootassignment.dao.StudentRepository;
import com.example.springbootassignment.entity.Student;

@Service
public class StudentServiceImplementation implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public List<Student> findAll() {
		
		List<Student> theStudents=studentRepository.findAll();
		return theStudents;
	}

	@Override
	public Student findById(int stdId) {
		Optional<Student> studentId=studentRepository.findById(stdId);
		Student newStdId=null;
		if(studentId.isPresent())
		{
			newStdId=studentId.get();
		}
		else
		{
			throw new RuntimeException("Student with id "+stdId+" Not found");
		}
		return newStdId;
	}

	@Override
	public Student save(Student stdId) {

		Student theStudent=studentRepository.save(stdId);
		return theStudent;
	}

	@Override
	public void deleteById(int stdId) {
		studentRepository.deleteById(stdId); 
	}

}
