package com.qa.persistence.repository;

import java.util.Collection;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.persistence.domian.ClassManagement;
import com.qa.util.JSONUtil;

public class ClassManageDBReop implements GenericRepo{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getSomthing(Long anID) {
		return util.getJSONForObject(manager.find(ClassManagement.class, anID));
	}

	public String getEverything() {
		Query query = manager.createQuery("SELECT c FROM CLASSROOM c");
		Collection<ClassManagement> classrooms = (Collection<ClassManagement>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}
	@Transactional(REQUIRED)
	public String createSomething(String classroom) {
		ClassManagement aClassroom = util.getObjectForJSON(classroom, ClassManagement.class);
		manager.persist(aClassroom);
		return "{\"message\": \"Classroom Succesfully Added\"}";
	}
	@Transactional(REQUIRED)
	public String updateSomething(Long anID, String update) {
		deleteSomething(anID);
		createSomething(update);
		return "{\"message\": \"Classroom Successfully Updated\"}";
	}
	@Transactional(REQUIRED)
	public String deleteSomething(Long anID) {
		manager.remove(getSomthing(anID));
		return "{\"message\": \"Classroom Successfully Deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

	

