package com.ba.app.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.StockPointProduct;

@Service
public interface StockPointProuctRepository extends CrudRepository<StockPointProduct, String> {
	
	StockPointProduct findByCode(String Code);
	
	List<StockPointProduct> findByMemberIdAndStatus(String memberId, String status);
	
	@Transactional
	List<StockPointProduct> findByMemberId(String memberId);
	
	StockPointProduct findByOrderNumber(Long orderNumber);
	
}