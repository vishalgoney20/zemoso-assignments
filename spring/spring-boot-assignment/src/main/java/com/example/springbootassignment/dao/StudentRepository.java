package com.example.springbootassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootassignment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
