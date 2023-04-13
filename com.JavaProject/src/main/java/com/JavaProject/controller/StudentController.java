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
import com.JavaProject.Entity.Student;
import com.JavaProject.services.CourseService;
import com.JavaProject.services.StudentServices;

@Controller
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/stu")
	public String student() {
		return "stu";
	}
	
	@PostMapping("/enter/student")
	public String stu(@RequestParam(value = "id", required = true) int id, ModelMap studentModel) {
		return"redirect:/student/"+id;
	}
	
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable int id, ModelMap studentModel) {
		Student student = studentServices.getStudent(id);
		List<Course> courses = courseService.getCourses();
		studentModel.addAttribute("student", student);
		studentModel.addAttribute("courses", courses);
		System.out.println("get.............................................");
		return "student";
	}
	
	@GetMapping("/students/{id}")
	public String getStudentss(@PathVariable int id, ModelMap studentModel) {
		Student student = studentServices.getStudent(id);
		List<Course> courses = courseService.getCourses();
		studentModel.addAttribute("student", student);
		studentModel.addAttribute("courses", courses);
		System.out.println("get.............................................");
		return "tstudent";
	}
	
	@PostMapping("/student/{id}")
	public String getcStudent(@RequestParam(value = "course_id", required = true) int cid,@PathVariable int id, ModelMap studentModel) {
		Student student = studentServices.getStudent(id);
		Course course = courseService.getCourse(cid);
		Student s = new Student(student.getId(), student.getName(), student.getRollno());
		boolean add = true;
		s.setCourses(student.getCourses());
		for(Course c:student.getCourses()) {
			if(c.getId() == cid) {
				add = false;
			}
		}
		if(add) {
			s.setCourse(course);
			studentServices.updateStudent(s);
		}
		studentModel.addAttribute("student", student);
		System.out.println("post...........................................");
		return"redirect:/student/{id}";
	}
	
	@GetMapping("/students")
	public String getStudents(ModelMap studentModel) {
		List<Student> students = studentServices.getStudents();
		studentModel.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping("addStudent")
	public String addPage() {
		return "addStudent";
	}
	
	@PostMapping("/add/student")
	public String addStudent(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "rollno", required = true) int rollno, ModelMap studentModel) {
		Student student = new Student();
		student.setName(name);
		student.setRollno(rollno);
		studentServices.addStudent(student);
		studentModel.addAttribute("msg", "Student Added Succesfully");
		List<Student> students = studentServices.getStudents();
		studentModel.addAttribute("students", students);
		return "redirect:/students";
	}
	
	@GetMapping("update/student/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap studentModel) {
		studentModel.addAttribute("id", id);
		Student student = studentServices.getStudent(id);
		studentModel.addAttribute("student", student);
		return "updateStudent";
	}

	@PostMapping("/update/student")
	public String updateStudent(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "rollno", required = true) int rollno, ModelMap studentModel) {
		Student student = new Student(id,name,rollno);
		studentServices.updateStudent(student);
		List<Student> students = studentServices.getStudents();
		studentModel.addAttribute("students", students);
		studentModel.addAttribute("id", id);
		studentModel.addAttribute("msg", "Student updated successfully");
		return "redirect:/students";
	}

	@GetMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable int id, ModelMap studentModel) {
		studentServices.deleteStudent(id);
		List<Student> students = studentServices.getStudents();
		studentModel.addAttribute("students", students);
		studentModel.addAttribute("msg", "Student deleted successfully");
		return "redirect:/students";
	}
}
