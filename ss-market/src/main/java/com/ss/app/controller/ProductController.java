package com.ss.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.app.entity.Category;
import com.ss.app.entity.Product;
import com.ss.app.model.CategoryCodeRepository;
import com.ss.app.model.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryCodeRepository categoryCodeRepository;

	
	@RequestMapping(value = "/manual/purchase", method = RequestMethod.GET)
	public String loadCategory(HttpServletRequest request, ModelMap model) {
		try {
			
			Iterable<Category> categoryList = categoryCodeRepository.findAll();
			model.addAttribute("categoryList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manualPurchase";
	}
	
	@RequestMapping("/loadProduct")
	public ResponseEntity<Iterable<Product>> loadDoctor(@RequestParam("categoryId") String category,HttpServletRequest request, ModelMap model) {

		List<Product> Product = productRepository.findByCategory(category);
		model.addAttribute("productList", Product);
		return new ResponseEntity(Product, HttpStatus.OK);
	}
}
