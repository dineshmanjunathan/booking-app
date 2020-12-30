package com.ss.app.model;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Member;

@Service
public interface UserRepository extends CrudRepository<Member, Long>{
	
	void deleteById(String userId);
	
	Optional<Member> findById(String id);
	
	@Query(value="select wallet from t_member m where m.member_id=:id", nativeQuery=true)
	Integer getWalletBalance(String id);

}