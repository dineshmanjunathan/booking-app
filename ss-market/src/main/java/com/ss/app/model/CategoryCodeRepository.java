package com.ss.app.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Category;

@Service
public interface CategoryCodeRepository extends CrudRepository<Category, Long>{
	
	void deleteById(String userId);

}