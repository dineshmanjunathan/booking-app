package com.ss.app.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Category;
import com.ss.app.entity.Purchase;

@Service
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}