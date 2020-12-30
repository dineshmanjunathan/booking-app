package com.hc.app.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hc.app.entity.Appointment;

@Service
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{
	
	void deleteById(String userId);

}