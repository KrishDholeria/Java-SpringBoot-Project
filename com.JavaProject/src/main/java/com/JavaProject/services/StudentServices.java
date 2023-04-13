package com.JavaProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Student;
import com.JavaProject.dao.StudentDao;

@Service
public class StudentServices {
	
	@Autowired
	private StudentDao studentDao;
	
	public Student getStudent(final int id) {
		return studentDao.getStudent(id);
	}

	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	public void addStudent(final Student Student) {
		studentDao.addStudent(Student);
	}

	public void updateStudent(final Student Student) {
		studentDao.updateStudent(Student);
	}

	public void deleteStudent(final int id) {
		studentDao.deleteStudent(id);
	}
}
