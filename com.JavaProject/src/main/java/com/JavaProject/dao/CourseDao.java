package com.JavaProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JavaProject.Entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CourseDao {

	private EntityManager entityManager;
	
	@Autowired
	public CourseDao(EntityManager theEntityManager) {
		super();
		this.entityManager = theEntityManager;
	}
	
	public Course getCourse(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Course course = currentSession.get(Course.class, id);
		currentSession.close();
		return course;
	}
	
	public List<Course> getCourses(){
		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Course> theQuery =
				currentSession.createQuery("from Course", Course.class);
		List<Course> courses = theQuery.getResultList();
		currentSession.close();
		return courses;
	}
	
	@Transactional
	public void addCourse(final Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(course);
		currentSession.close();
	}
	
	@Transactional
	public void updateCourse(final Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(course);
		currentSession.close();
	}
	
	@Transactional
	public void deleteCourse(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		Course course = currentSession.get(Course.class, id);
		currentSession.remove(course);
		currentSession.close();
				
	}
}
