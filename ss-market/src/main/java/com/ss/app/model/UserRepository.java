package com.ss.app.model;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Member;

@Service
public interface UserRepository extends CrudRepository<Member, Long>{
	
	void deleteById(String userId);
	
	Optional<Member> findById(String id);
	
	List<Member> findByReferedby(String id);
	
	@Query(value="select referencecode from t_member m where m.referencecode=:id", nativeQuery=true)
	String checkSponserExists(String id);
	
	Optional<Member> findByIdAndPasswordAndRole(String id, String password, String role);

}