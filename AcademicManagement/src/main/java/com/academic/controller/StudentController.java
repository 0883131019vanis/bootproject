package com.academic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.academic.entity.Student;
import com.academic.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/studentRegistration")
	public String studentRegistration(Model model) {
		List<Student> student = studentService.getAllStudent();
		model.addAttribute("student", student);
		return "studentRegistration.html";
	}
	@PostMapping("/students")
	public String listStudent(@ModelAttribute Student student, HttpSession session) 
	{      
		studentService.addStudent(student);
		session.setAttribute("Studentmsg", " Student Add Success");
		return "redirect:/studentRegistration";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {

		Student student = studentService.getStudentId(id);
		model.addAttribute("student", student);
		return "studentEdit.html";
	}

	@PostMapping("/update")
	public String UpdateStudent(@ModelAttribute Student student, HttpSession session) 
	{      
		studentService.addStudent(student);
		session.setAttribute("Studentmsg", "Student update succefully");
		return "redirect:/studentRegistration";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id,HttpSession session) {
		studentService.deleteStudentById(id);
		session.setAttribute("Studentmsg", "Student Delete succefully");
		return "redirect:/studentRegistration";
	}
	@GetMapping("/studentdetails")
	public String studentDetails(Model model) {
		List<Student> student = studentService.findStudentDetails();
		model.addAttribute("student", student);
		return "studentView.html";
	}


}
