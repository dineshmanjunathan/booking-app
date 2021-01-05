package com.ss.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.app.entity.Category;
import com.ss.app.entity.Purchase;
import com.ss.app.model.CategoryRepository;
import com.ss.app.model.PurchaseRepository;

@Controller
public class TransactionManagerController {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/save/purchase", method = RequestMethod.POST)
	public String savePurchase(HttpServletRequest request, Purchase purchase, ModelMap model) {
		try {

			Purchase purchaseEntity = new Purchase();
			BeanUtils.copyProperties(purchase, purchaseEntity);
			purchaseRepository.save(purchaseEntity);
			model.addAttribute("successMessage", "Item Purchased Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manualPurchase";
	}
	
	@RequestMapping(value = "/purchase/detail", method = RequestMethod.GET)
	public String loadPurchase(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Purchase> purchaseList = purchaseRepository.findByMemberid(memberId);
			model.addAttribute("purchaseList", purchaseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseDetails";
	}
	
	@RequestMapping(value = "/manual/purchase", method = RequestMethod.GET)
	public String loadCategory(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Category> categoryList = categoryRepository.findAll();
			model.addAttribute("categoryList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manualPurchase";
	}

}
