package com.ss.app.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.ss.app.entity.SSConfiguration;

@Service
public interface SSConfigRepository extends CrudRepository<SSConfiguration, String> {

	Optional<SSConfiguration> findById(String i);
	
	@Transactional
	Long deleteByCode(String Code);

}