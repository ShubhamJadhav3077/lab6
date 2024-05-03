package com.lab6.CollegeFest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lab6.CollegeFest.entity.Student;
import com.lab6.CollegeFest.serviceimpl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentServiceImpl;

	@RequestMapping("/studentsview")
	public String studentsList(Model model) {
		List<Student> listStudents = studentServiceImpl.getAllStudents();
		model.addAttribute("allStudents", listStudents);
		return "students";
	}

	@GetMapping("/students/addform")
	public String createStudent(Model model) {
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		return "create_student";
	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute Student student) {
		studentServiceImpl.addStudent(student);
		return "redirect:/studentsview";
	}

	@GetMapping("/students/editform/{id}")
	public String editStudent(@PathVariable("id") int studentId, Model model) {
		Student editStudent = studentServiceImpl.getStudent(studentId);
		model.addAttribute("student", editStudent);
		return "edit_student";
	}

	@PostMapping("/updatestudent/{id}")
	public String updateStudent(@PathVariable("id") int studentId, @ModelAttribute("student") Student student) {
		studentServiceImpl.updateStudent(studentId, student);
		return "redirect:/studentsview";
	}

	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") int studentId) {
		studentServiceImpl.deleteStudent(studentId);
		return "redirect:/studentsview";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenie(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("message", "Hi" + user.getName() + ",you do not have permission to access the page !");
		} else {
			model.addObject("message", "You do not have permission to access this page !");
		}
		model.setViewName("403");
		return model;

	}

}
