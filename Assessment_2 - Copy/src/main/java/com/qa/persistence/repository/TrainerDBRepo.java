package com.qa.persistence.repository;

import java.util.Collection;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domian.TrainerManagement;
import com.qa.util.JSONUtil;

public class TrainerDBRepo implements GenericRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getSomthing(Long anID) {
		return util.getJSONForObject(manager.find(TrainerManagement.class, anID));
	}

	public String getEverything() {
		Query query = manager.createQuery("SELECT c FROM Trainer c");
		Collection<TrainerManagement> trainers = (Collection<TrainerManagement>) query.getResultList();
		return util.getJSONForObject(trainers);
	}
	@Transactional(REQUIRED)
	public String createSomething(String createThis) {
		TrainerManagement aTrainer = util.getObjectForJSON(createThis, TrainerManagement.class);
		manager.persist(aTrainer);
		return "{\"message\": \"Trainer Successfully added\"}";
	}
	@Transactional(REQUIRED)
	public String updateSomething(Long anID, String update) {
		deleteSomething(anID);
		createSomething(update);
		return "{\"message\": \"Trainer Successfully Updated\"}";
	}
	@Transactional(REQUIRED)
	public String deleteSomething(Long anID) {
		manager.remove(getSomthing(anID));
		return "{\"message\": \"Trainer Successfully Deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}

