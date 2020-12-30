package com.ss.app.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.CountryCode;

@Service
public interface CountryCodeRepository extends CrudRepository<CountryCode, Long>{
	
	void deleteById(String userId);

}