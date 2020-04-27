package com.example.springbootassignment;

import com.example.springbootassignment.entity.Course;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springbootassignment.dao.CoursesRepository;
import com.example.springbootassignment.service.CourseService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
@SpringBootTest
class SpringBootAssignmentApplicationTests {

	@MockBean
	private CoursesRepository coursesRepository;
	
	@Autowired
	private CourseService courseService;

	@Test
	public void findAllTest() {

		Mockito.when(coursesRepository.findAll()).thenReturn(Stream.of(new Course("Java","75 hours"),
												new Course("Python","70 hours")).collect(Collectors.toList()));
		Assert.assertEquals(2,courseService.findAll().size());
	}

	@Test
	public void findByIdTest(){
		int id=1;
		Course theCourse=new Course("Java","75 hours");

		Mockito.when(coursesRepository.findById(id)).thenReturn(Optional.of(theCourse));
		Assert.assertEquals("Java",courseService.findById(id).getCourseName());
	}

	@Test
	public void saveTest(){
		Course newCourse=new Course("Data Science","60 hours");

		Mockito.when(coursesRepository.save(newCourse)).thenReturn(newCourse);
		Assert.assertEquals(newCourse,courseService.save(newCourse));
	}

	@Test
	public void deleteTest(){
		Course theCourse=new Course("Data Science","60 hours");
		courseService.deleteById(theCourse.getId());
		Mockito.verify(coursesRepository,Mockito.times(1)).deleteById(theCourse.getId());
	}

}
