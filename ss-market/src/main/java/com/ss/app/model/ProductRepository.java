package com.ss.app.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Product;

@Service
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategory(String Category);
}