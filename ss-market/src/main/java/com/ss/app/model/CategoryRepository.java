package com.ss.app.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ss.app.entity.Category;

@Service
public interface CategoryRepository extends CrudRepository<Category, Long> {

}