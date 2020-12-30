package com.ss.app.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.UserMaster;

@Service
public interface UserRepository extends CrudRepository<UserMaster, Long>{
	
	void deleteById(String userId);
	
	UserMaster findByMobile(String mobile);

}