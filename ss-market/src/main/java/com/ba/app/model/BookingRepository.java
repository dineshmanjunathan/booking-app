package com.ba.app.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.Booking;

@Service
public interface BookingRepository extends CrudRepository<Booking, String> {
	
}
