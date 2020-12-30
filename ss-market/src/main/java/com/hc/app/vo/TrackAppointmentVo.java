package com.hc.app.vo;

import com.hc.app.entity.Category;
import com.hc.app.entity.DoctorDetails;

public class TrackAppointmentVo {
	
	private Long id;
	private Category category;
	private DoctorDetails doctor;
	private String date;
	private String time;
	private String status;
	private String doctorId;
	private String patientd;
	
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientd() {
		return patientd;
	}
	public void setPatientd(String patientd) {
		this.patientd = patientd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public DoctorDetails getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDetails doctor) {
		this.doctor = doctor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
