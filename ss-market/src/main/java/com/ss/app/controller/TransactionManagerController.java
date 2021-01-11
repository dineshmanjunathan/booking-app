package com.ss.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.app.entity.Cart;
import com.ss.app.entity.Category;
import com.ss.app.entity.Product;
import com.ss.app.entity.Purchase;
import com.ss.app.model.CartRepository;
import com.ss.app.model.CategoryRepository;
import com.ss.app.model.ProductRepository;
import com.ss.app.model.PurchaseRepository;

@Controller
public class TransactionManagerController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@RequestMapping(value = "/purchase/order", method = RequestMethod.POST)
	public String savePurchase(HttpServletRequest request, Purchase purchase, ModelMap model) {
		try {
			//TODO
			// decrease qty in product table.
			// update active days date in member table
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
	@RequestMapping(value = "/purchase/review", method = RequestMethod.GET)
	public String purchaseReview(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			model.addAttribute("cartList", cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseReview";
	}

	@RequestMapping(value = "/purchase/review/edit", method = RequestMethod.GET)
	public String reviewEdit(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			Map<String, Long> map = new HashMap<>();
			cart.forEach(c -> {
				map.put(c.getProdCode(), c.getQuantity());
			});

			Iterable<Product> productList = productRepository.findAll();
			model.addAttribute("productList", productList);
			model.addAttribute("cartMap", map);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseProductList";
	}
	
	@RequestMapping(value = "/purchase/addToCart", method = RequestMethod.POST)
	public String addTocart(HttpServletRequest request, ModelMap model, @RequestParam("prodCode") String prodCode, @RequestParam("qty") String qty) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			Cart existingCart = cartRepository.findByMemberidAndProdCode(memberId, prodCode);
			if(existingCart != null) {
				existingCart.setQuantity(Long.parseLong(qty));
				cartRepository.save(existingCart);
			} else {
				Product product = productRepository.findByCode(prodCode);
				Cart cart = new Cart();
				cart.setProdCode(product.getCode());
				cart.setProdDesc(product.getProdDesc());
				cart.setMemberid(memberId);
				cart.setQuantity(Long.parseLong(qty));
				cart.setAmount(product.getPrice());
				cartRepository.save(cart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseReview";
	}
	
	@RequestMapping(value = "/purchase/remove/cart", method = RequestMethod.POST)
	public String removeFromCarty(HttpServletRequest request, ModelMap model, @RequestParam("prodCode") String prodCode) {
		try {
			cartRepository.removeCart(prodCode, (String) request.getSession().getAttribute("MEMBER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseReview";
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
	
	@RequestMapping(value = "/purchase/pending/list", method = RequestMethod.GET)
	public String pendingTxnList(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Purchase> purchaseList = purchaseRepository.findByOrderStatus("P");
			model.addAttribute("purchaseList", purchaseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trasnactionApprove";
	}
	
	
	@RequestMapping(value = "/purchase/approve", method = RequestMethod.GET)
	public String approvePurchase(HttpServletRequest request, ModelMap model, @RequestParam("id") String id) {
		try {
			Purchase purchase = purchaseRepository.findById(Long.parseLong(id)).get();
			
			if(purchase!=null && purchase.getId()!=null) {
				purchase.setOrderStatus("A");
				model.addAttribute("successMessage","Order No:"+purchase.getOrderNumber()+" Approved Successfully.");
				purchase = purchaseRepository.save(purchase);
				Iterable<Purchase> purchaseList = purchaseRepository.findByOrderStatus("P");
				model.addAttribute("purchaseList", purchaseList);
				
			}else {
				model.addAttribute("errorMessage","Try Again Later!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trasnactionApprove";
	}

}
