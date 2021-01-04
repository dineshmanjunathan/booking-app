package com.ss.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionManagerController {
	
	@RequestMapping("/manual/purchase")
	public String login(HttpServletRequest request,ModelMap model) {
		return "manualPurchase";
	} 

}
