package com.JavaProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Course;
import com.JavaProject.dao.CourseDao;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public Course getCourse(final int id) {
		return courseDao.getCourse(id);
	}
	
	public List<Course> getCourses(){
		return courseDao.getCourses();
	}
	
	public void addCourse(final Course course) {
		courseDao.addCourse(course);
	}
	
	public void updateCourse(final Course course) {
		courseDao.updateCourse(course);
	}
	
	public void deleteCourse(final int id) {
		courseDao.deleteCourse(id);
	}
}
