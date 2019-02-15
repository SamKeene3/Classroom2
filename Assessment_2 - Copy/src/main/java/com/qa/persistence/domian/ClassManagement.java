package com.qa.persistence.domian;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassManagement {
	
	@Id
	@GeneratedValue
	private Long 	classRoomId;
	private Long 	trainerId; 
	private	Set<TraineeManagement> trainees;
	
	
	public ClassManagement() {
		super();
	}
	
	public ClassManagement( Long id , Long trainerId) {
		
		super();
		this.classRoomId = id;
		this.trainerId = trainerId;
		
	}

	public Long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public Set<TraineeManagement> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<TraineeManagement> trainees) {
		this.trainees = trainees;
	}

	
	
}
