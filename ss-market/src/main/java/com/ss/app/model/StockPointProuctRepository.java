package com.ss.app.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.StockPointProduct;

@Service
public interface StockPointProuctRepository extends CrudRepository<StockPointProduct, String> {
	
	StockPointProduct findByCode(String Code);
	
	List<StockPointProduct> findByMemberId(String memberId);

}