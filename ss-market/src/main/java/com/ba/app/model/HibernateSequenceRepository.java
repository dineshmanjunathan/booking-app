package com.ba.app.model;



import org.springframework.data.repository.CrudRepository;

import com.ba.app.entity.HibernateSequence;

import java.util.UUID;

public interface HibernateSequenceRepository extends CrudRepository<HibernateSequence, UUID> {
	
}