package com.academic.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academic.service.StudentService;

@Controller
public class AcademicController {
	@Autowired 
	StudentService studentService;

	@RequestMapping("/home")
	public String getHome() {
		return "home.html";
	}

	@RequestMapping("/admin")
	public String getAdmin() {
		return "admin.html";
	}
	
	
	@RequestMapping("/teacher")
	public String getTeacher() {
		return "teacher.html";
	}
	
	}
