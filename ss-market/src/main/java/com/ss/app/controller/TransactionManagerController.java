package com.ss.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.ss.app.entity.Category;
import com.ss.app.entity.Product;
import com.ss.app.entity.Purchase;
import com.ss.app.model.CategoryRepository;
import com.ss.app.model.ProductRepository;
import com.ss.app.model.PurchaseRepository;
import com.ss.app.vo.CartVo;

@Controller
public class TransactionManagerController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/save/purchase", method = RequestMethod.POST)
	public String savePurchase(HttpServletRequest request, Purchase purchase, ModelMap model) {
		try {

			Purchase purchaseEntity = new Purchase();
			BeanUtils.copyProperties(purchase, purchaseEntity);
			purchaseRepository.save(purchaseEntity);
			model.addAttribute("successMessage", "Item Purchased Successfully");

			Iterable<Category> categoryList = categoryRepository.findAll();
			model.addAttribute("categoryList", categoryList);

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

	@RequestMapping(value = "/purchase/list", method = RequestMethod.GET)
	public String purchaseList(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Product> productList = productRepository.findAll();
			model.addAttribute("productList", productList);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseProductList";
	}

	@RequestMapping(value = "/purchase/loadProduct/{catId}", method = RequestMethod.GET)
	public String loadProduct(@PathVariable String catId, HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Product> productList = productRepository.findByCategory(catId);
			model.addAttribute("productList", productList);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseProductList";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/purchase/review/{cart}/{total}", method = RequestMethod.GET)
	public String purchaseReview(HttpServletRequest request, ModelMap model, @PathVariable("cart") String cart, @PathVariable("total") String total) {
		try {
			Gson gson = new Gson();
			HashMap<String, CartVo> cartMap = gson.fromJson(cart, HashMap.class);
			model.addAttribute("cartMap", cartMap);
			model.addAttribute("cartTotal", total);
			HttpSession session = request.getSession();
			session.setAttribute("cartMap", cartMap);
			session.setAttribute("cartTotal", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseReview";
	}
	
	@RequestMapping(value = "/purchase/review/edit", method = RequestMethod.GET)
	public String reviewEdit(HttpServletRequest request, ModelMap model) {
		try {
			HttpSession session = request.getSession();
			HashMap<String, CartVo> cartMap = (HashMap<String, CartVo>) session.getAttribute("cartMap");
			HashMap<String, Long> map = new HashMap<>();
			model.addAttribute("cartTotal", session.getAttribute("cartTotal"));
			Iterable<Product> productList = productRepository.findAll();
			cartMap.entrySet().stream()
		      .forEach(e -> {
		    	  map.put(e.getKey(), Long.parseLong(e.getValue().getQty()));
		      });			
			model.addAttribute("productList", productList);
			model.addAttribute("cartMap", map);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseProductList";
	}
	
	@RequestMapping(value = "/purchase/all/list", method = RequestMethod.GET)
	public String allTxnList(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Purchase> purchaseList = purchaseRepository.findAll();
			model.addAttribute("purchaseList", purchaseList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "allTransactionList";
	}

}
