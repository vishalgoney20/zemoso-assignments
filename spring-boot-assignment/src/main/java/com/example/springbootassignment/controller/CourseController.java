package com.example.springbootassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootassignment.entity.Course;
import com.example.springbootassignment.entity.Student;
import com.example.springbootassignment.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showCourses(Model theModel) {
		List<Course> theCourses=courseService.findAll();
		theModel.addAttribute("courses",theCourses);
		return "courses/show-courses";
	}
	
	@GetMapping("/addCourse")
	public String addCourse(Model theModel) {
		Course newCourse=new Course();
		theModel.addAttribute("course",newCourse);
		return "courses/add-course";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("course") Course theCourse,BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors())
		{
			return "courses/add-course";
		}
		else
		{
			courseService.save(theCourse);
			return "redirect:/courses/list";	
		}
	} 
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,Model theModel) {
		
		Course theCourse=courseService.findById(theId);
		theModel.addAttribute("course",theCourse);
		return "courses/add-course";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		courseService.deleteById(theId);
		return "redirect:/courses/list"; 
	}
	
	@GetMapping("/getStudents")
	public String getStudents(@RequestParam("courseId") int cId,Model theModel) {
		Course newCid=courseService.findById(cId);
		
		List<Student> theStudents=newCid.getStudents();
		theModel.addAttribute("students",theStudents);
		return "courses/show-registered-students";
	}
	
}
