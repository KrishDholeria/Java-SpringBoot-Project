package com.JavaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JavaProject.Entity.Course;
import com.JavaProject.services.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course/{id}")
	public String getCourse(@PathVariable int id, ModelMap courseModel) {
		Course course = courseService.getCourse(id);
		courseModel.addAttribute("course", course);
		return "course";
	}
	
	@GetMapping("/courses")
	public String getCouurses(ModelMap courseModel) {
		List<Course> courses = courseService.getCourses();
		courseModel.addAttribute("courses",courses);
		return "courses";
	}
	
	@GetMapping("addCourse")
	public String addPage() {
		return "addCourse";
	}
	
	@PostMapping("/add/course")
	public String addStudent(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "description", required = true) String description, ModelMap courseModel) {
		Course course = new Course();
		course.setName(name);
		course.setDescription(description);
		courseService.addCourse(course);
		courseModel.addAttribute("msg", "Course Added Succesfully");
		List<Course> courses = courseService.getCourses();
		courseModel.addAttribute("courses", courses);
		return "redirect:/courses";
	}
	
	@GetMapping("update/course/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap courseModel) {
		courseModel.addAttribute("id", id);
		Course course = courseService.getCourse(id);
		courseModel.addAttribute("course", course);
		return "updateCourse";
	}

	@PostMapping("/update/course")
	public String updateCourse(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = true) String description, ModelMap courseModel) {
		Course course = new Course(id,name,description);
		courseService.updateCourse(course);
		List<Course> courses = courseService.getCourses();
		courseModel.addAttribute("courses", courses);
		courseModel.addAttribute("id", id);
		courseModel.addAttribute("msg", "Course updated successfully");
		return "redirect:/courses";
	}

	@GetMapping("/delete/course/{id}")
	public String deleteCourse(@PathVariable int id, ModelMap courseModel) {
		courseService.deleteCourse(id);
		List<Course> courses = courseService.getCourses();
		courseModel.addAttribute("courses", courses);
		courseModel.addAttribute("msg", "Course deleted successfully");
		return "redirect:/courses";
	}
}
