package com.JavaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JavaProject.Entity.Teacher;
import com.JavaProject.services.TeacherService;


@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService; 
	
	@GetMapping("/teacher")
	public String teacher() {
		return "teacher";
	}
	
	@PostMapping("/enter/teacher")
	public String enterTeacher(@RequestParam(value = "id", required = true) int id, ModelMap teacherModel) {
		Teacher teacher = teacherService.getTeacher(id);
		teacherModel.addAttribute("teacher", teacher);
		return "teacherPage";
	}
	
	@GetMapping("addTeacher")
	public String addPage() {
		return "add";
	}

	@PostMapping("/add/teacher")
	public String addTeacher(@RequestParam(value = "name", required = true) String name, ModelMap teacherModel) {
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacherService.addTeacher(teacher);
		teacherModel.addAttribute("msg", "Teacher added successfully");
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "redirect:/teacher";
	}

}
