package com.ba.app.model;

import java.util.List;

import javax.persistence.OrderBy;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.Product;

@Service
public interface ProductRepository extends CrudRepository<Product, String> {

	List<Product> findByCategory(String Category);

	@Transactional
	@OrderBy("Code ASC")
	Product findByCode(String Code);
	
	@Transactional
	Long deleteByCode(String code);
}