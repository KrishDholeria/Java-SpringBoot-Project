package com.JavaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JavaProject.Entity.Result;
import com.JavaProject.Entity.Student;
import com.JavaProject.services.ResultService;
import com.JavaProject.services.StudentServices;

@Controller
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("addResult")
	public String addPage(ModelMap resultModel) {
		List<Student> students = studentServices.getStudents();
		resultModel.addAttribute("students", students);
		return "addResult";
	}
	
	@PostMapping("/add/result")
	public String addResult(@RequestParam(value = "cpi", required = true) int cpi, @RequestParam(value = "spi", required = true) int spi, @RequestParam(value = "student_id", required = true) int sid, ModelMap resultModel) {
		Student student = new Student();
		Student s = studentServices.getStudent(sid);
		student.setName(s.getName());
		student.setCourses(s.getCourses());
		student.setRollno(s.getRollno());
		student.setId(sid);
		Result res = new Result();
		res.setCpi(cpi);
		res.setSpi(spi);
		resultService.addResult(res);
		student.setResult(res);
		studentServices.updateStudent(student);
		System.out.println(sid);
		resultModel.addAttribute("msg", "Result Added Succesfully");
		return"redirect:/students	/"+sid;
	}
	
	@GetMapping("updateResult")
	public String updatePage(ModelMap resultModel) {
		List<Student> students = studentServices.getStudents();
		resultModel.addAttribute("students", students);
		return "addResult";
	}
}
