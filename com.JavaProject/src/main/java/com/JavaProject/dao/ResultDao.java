package com.JavaProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JavaProject.Entity.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ResultDao {

	private EntityManager entityManager;
	
	@Autowired
	public ResultDao(EntityManager theEntityManager) {
		super();
		this.entityManager = theEntityManager;
	}
	
	public Result getResult(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Result result = currentSession.get(Result.class, id);
		currentSession.close();
		return result;
	}
	
	public List<Result> getResult(){
		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Result> theQuery =
				currentSession.createQuery("from Result", Result.class);
		List<Result> result = theQuery.getResultList();
		currentSession.close();
		return result;
	}
	
	@Transactional
	public void addResult(final Result result) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(result);
		currentSession.close();
	}
	
	@Transactional
	public void updateResult(final Result result) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(result);
		currentSession.close();
	}
	
	@Transactional
	public void deleteResult(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Result result = currentSession.get(Result.class, id);
		currentSession.remove(result);
		currentSession.close();
				
	}
}

