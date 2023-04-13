package com.JavaProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JavaProject.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public Student getStudent(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		currentSession.close();
		return student;
	}

	public List<Student> getStudents() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		TypedQuery<Student> theQuery =
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		currentSession.close();
		return students;
	}
	
	@Transactional
	public void addStudent(final Student student) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(student);
		currentSession.close();
	}

	@Transactional
	public void updateStudent(final Student student) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(student);
		currentSession.close();
	}
	
	@Transactional
	public void deleteStudent(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		Student student = currentSession.get(Student.class, id);
		currentSession.remove(student);
		currentSession.close();
				
	}
}
