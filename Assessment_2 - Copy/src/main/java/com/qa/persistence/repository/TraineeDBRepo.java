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

import com.qa.persistence.domian.TraineeManagement;
import com.qa.util.JSONUtil;
@Transactional(SUPPORTS)
@Default
public class TraineeDBRepo implements GenericRepo {
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getSomthing(Long anID) {
			return util.getJSONForObject(manager.find(TraineeManagement.class, anID));
		}

		public String getEverything() {
			Query query = manager.createQuery("SELECT c FROM Trainee c");
			Collection<TraineeManagement> Trainees = (Collection<TraineeManagement>) query.getResultList();
			return util.getJSONForObject(Trainees);
		}
		@Transactional(REQUIRED)
		public String createSomething(String trainer) {
			TraineeManagement aTrainee = util.getObjectForJSON(trainer, TraineeManagement.class);
			manager.persist(aTrainee);
			return "{\"message\": \"Trainee added\"}";
		}
		@Transactional(REQUIRED)
		public String updateSomething(Long anID, String update) {
			deleteSomething(anID);
			createSomething(update);
			return "{\"message\": \"Trainee sucessfully Updated\"}";
		}
		@Transactional(REQUIRED)
		public String deleteSomething(Long anID) {
			manager.remove(getSomthing(anID));
			return "{\"message\": \"Trainee sucessfully deleted\"}";
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}
		
		

	}
