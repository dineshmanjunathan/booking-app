package com.ba.app.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.Category;

@Service
public interface CategoryRepository extends CrudRepository<Category, String> {

	Category findByCode(String Code);
	
	@Transactional
	void deleteByCode(String Code);
}