package com.ss.app.model;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Member;

@Service
public interface UserRepository extends CrudRepository<Member, String>{
	
	void deleteById(String userId);
	
	Optional<Member> findById(String id);

}