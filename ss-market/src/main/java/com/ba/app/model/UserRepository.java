package com.ba.app.model;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.User;

@Service
public interface UserRepository extends CrudRepository<User, String>{
		
	Optional<User> findById(String id);
	
	Optional<User> findByIdAndPasswordAndRole(String id, String password, String role);
	
	@Transactional
	void deleteById(String id);

}