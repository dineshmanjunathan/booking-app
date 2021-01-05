package com.ss.app.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Purchase;

@Service
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

	List<Purchase> findByMemberid(String memberid);
}