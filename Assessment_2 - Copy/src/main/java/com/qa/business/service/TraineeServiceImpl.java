package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GenericRepo;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements GenericService{
	
	@Inject
	private GenericRepo repo;
	
	@Inject
	JSONUtil util;

	public String createSomething(String creatable) {
		return repo.createSomething(creatable);
	}

	public String getEverything() {
		return repo.getEverything();
	}

	public String getSomething(Long anID) {
		return repo.getSomthing(anID);
	}

	public String updateSomething(String update, Long anID) {
		return repo.updateSomething(anID, update);
	}

	public String deleteSomething(Long anID) {
		return repo.deleteSomething(anID);
	}
	
	public void setRepo(GenericRepo repo) {
		this.repo = repo;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}
