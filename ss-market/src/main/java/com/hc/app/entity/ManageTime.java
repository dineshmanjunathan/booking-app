package com.hc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "t_manage_time")
	public class ManageTime {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String categoryId;
		private String doctorId;
		private String session;
		private String timeDiff;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		public String getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(String doctorId) {
			this.doctorId = doctorId;
		}
		public String getSession() {
			return session;
		}
		public void setSession(String session) {
			this.session = session;
		}
		public String getTimeDiff() {
			return timeDiff;
		}
		public void setTimeDiff(String timeDiff) {
			this.timeDiff = timeDiff;
		}
		
		

}
