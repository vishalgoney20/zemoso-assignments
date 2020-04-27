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

import com.example.springbootassignment.entity.Student;
import com.example.springbootassignment.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String showStudents(Model theModel) {

		List<Student> theStudents=studentService.findAll();

		//	for(Student s:theStudents)
		//	{
		//	System.out.println(s);
		//	}
		theModel.addAttribute("students",theStudents);
		return "students/show-students";

	}

	@GetMapping("/addStudent")
	private String addStudent(Model theModel) {

		Student newStudent=new Student();
		theModel.addAttribute("student",newStudent);
		return "students/add-student";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("student") Student theStudent,BindingResult theBindingResult) {
		if(theBindingResult.hasErrors())
		{
			return "students/add-student";
		}
		else
		{
			studentService.save(theStudent);
			return "redirect:/students/list";
		}
	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int stdId,Model theModel) {
		Student theId=studentService.findById(stdId);
		theModel.addAttribute("student",theId);
		return "students/add-student";
	}
	@GetMapping("delete")
	public String delete(@RequestParam("studentId") int stdId) {
		studentService.deleteById(stdId);
		return "redirect:/students/list";
	}
}
