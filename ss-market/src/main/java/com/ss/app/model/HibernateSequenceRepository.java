package com.ss.app.model;



import org.springframework.data.repository.CrudRepository;

import com.ss.app.entity.HibernateSequence;

import java.util.UUID;

public interface HibernateSequenceRepository extends CrudRepository<HibernateSequence, UUID> {
	
}