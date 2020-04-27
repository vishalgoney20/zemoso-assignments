package com.example.springbootassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootassignment.entity.Course;

public interface CoursesRepository extends JpaRepository<Course, Integer> {

}
