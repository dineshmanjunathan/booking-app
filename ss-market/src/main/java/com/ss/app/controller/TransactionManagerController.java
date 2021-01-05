package com.ss.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.app.entity.Purchase;
import com.ss.app.model.PurchaseRepository;

@Controller
public class TransactionManagerController {

	@Autowired
	private PurchaseRepository purchaseRepository;

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

}
