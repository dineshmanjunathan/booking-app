package com.ss.app.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.DoctorDetails;



@Service
public interface DoctorDetailsRepository extends CrudRepository<DoctorDetails, Long>{
	
	List<DoctorDetails> findByCategoryId(Long id);

}
