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
import org.yaml.snakeyaml.error.Mark;

import com.academic.entity.Student;
import com.academic.entity.Teacher;
import com.academic.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@GetMapping("/teacherRegistration")
	public String teacherRegistration(Model model) {
		List<Teacher> teacher = teacherService.getAllTeacher();
		model.addAttribute("teacher", teacher);
		return "teacherRegistration.html";
	}
	@PostMapping("/teacher")
	public String listTeacher(@ModelAttribute Teacher teacher, HttpSession session) {
		teacherService.addTeacher(teacher);
		session.setAttribute("teachermsg", "teacher add success");
		return "redirect:/teacherRegistration";
	}

	@GetMapping("/editTeacher/{id}")
	public String edit(@PathVariable long id, Model model) {
		Teacher teacher = teacherService.getTeacherId(id);
		model.addAttribute("teacher", teacher);
		return "teacherEdit.html";
	}
	@PostMapping("/teacherupdate")
	public String UpdateTeacher(@ModelAttribute Teacher teacher, HttpSession session) {
		teacherService.addTeacher(teacher);
		session.setAttribute("teachermsg", "update teacher succefully");
		return "redirect:/teacherRegistration";
	}
	@GetMapping("/Teacherdelete/{id}")
	public String deleteTeacher(@PathVariable long id, HttpSession session) {
		teacherService.deleteTeacherById(id);
		session.setAttribute("teachermsg", "delete  teacher succefully");
		return "redirect:/teacherRegistration";
	}
	@GetMapping("/teacherdetails")
	public String studentDetails(Model model) {
		List<Teacher> teacher = teacherService.findTeacherDetails();
		model.addAttribute("teacher", teacher);
		return "teacherView.html";
	}

}
