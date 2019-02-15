package com.qa.persistence.domian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;	
	@Entity
	@Table(name="TRAINEES")
	public class TraineeManagement{
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne @JoinColumn(name="Room_Id", nullable = false)
		private ClassManagement room;
		
		private String firstName;
		private String lastName;

		public TraineeManagement() {
			super();
		}

		public TraineeManagement(Long id, String firstName, String lastName) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
