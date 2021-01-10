package com.ss.app.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Category;
import com.ss.app.entity.Product;

@Service
public interface CategoryRepository extends CrudRepository<Category, String> {

	Category findByCode(String Code);
	
	void deleteByCode(String Code);
}