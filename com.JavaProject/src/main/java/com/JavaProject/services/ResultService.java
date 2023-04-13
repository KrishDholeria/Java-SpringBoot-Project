package com.JavaProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Result;
import com.JavaProject.dao.ResultDao;

@Service
public class ResultService {
	
	@Autowired
	private ResultDao resultDao;
	
	public Result getResult(final int id) {
		return resultDao.getResult(id);
	}
	
	public List<Result> getResult(){
		return resultDao.getResult();
	}
	
	public void addResult(final Result result) {
		resultDao.addResult(result);
	}
	
	public void updateResult(final Result result) {
		resultDao.updateResult(result);
	}
	
	public void deleteResult(final int id) {
		resultDao.deleteResult(id);
	}
}
