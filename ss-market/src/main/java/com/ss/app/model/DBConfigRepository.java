package com.ss.app.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.DBConfiguration;

@Service
public interface DBConfigRepository extends CrudRepository<DBConfiguration, String> {

	Optional<DBConfiguration> findById(String i);

}