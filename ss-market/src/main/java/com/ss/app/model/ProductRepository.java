package com.ss.app.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Product;

@Service
public interface ProductRepository extends CrudRepository<Product, String> {

	List<Product> findByCategory(String Category);

	Product findByCode(String Code);

	@Query(value = "delete from t_product where Code=:Code", nativeQuery = true)
	void removeProduct(String Code);
}