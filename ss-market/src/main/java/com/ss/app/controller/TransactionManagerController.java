package com.ss.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.app.entity.Cart;
import com.ss.app.entity.Category;
import com.ss.app.entity.Member;
import com.ss.app.entity.Product;
import com.ss.app.entity.Purchase;
import com.ss.app.entity.StockPointProduct;
import com.ss.app.model.CartRepository;
import com.ss.app.model.CategoryRepository;
import com.ss.app.model.ProductRepository;
import com.ss.app.model.PurchaseRepository;
import com.ss.app.model.StockPointProuctRepository;
import com.ss.app.model.UserRepository;
import com.ss.utils.Utils;

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
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StockPointProuctRepository stockPointProuctRepository;

	@RequestMapping(value = "/purchase/confirm", method = RequestMethod.GET)
	public String savePurchase(HttpServletRequest request, ModelMap model) {
		try {
			// update active days date in member table
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			//Get order number
			Long orderNumber = Utils.getOrderNumber();
			Purchase purchase = new Purchase();
			Member member =userRepository.findById(memberId).get();
			for(Cart c:cart) {
				// Update qty in product
				Product prod = productRepository.findByCode(c.getCode());
				prod.setQuantity(prod.getQuantity() - c.getQuantity());
				productRepository.save(prod);
				
				//Prepare purchase
				preparePurchase(member, orderNumber, purchase, c, prod);
			}
			cartRepository.deleteByMemberid(memberId);
			//TODO calculate date and update in DB.
			//member.setActive_days(active_days);
			//userRepository.save(member);
			
			//TODO email to member email address
			model.addAttribute("cartList", cart);
			model.addAttribute("orderNumber", orderNumber);
			model.addAttribute("successMessage", "Item Purchased Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseConfirmation";
	}
	
	@RequestMapping(value = "/purchase/manual/confirm", method = RequestMethod.GET)
	public String saveManualPurchase(HttpServletRequest request, ModelMap model, @RequestParam(required = false) String memberid) {
		try {
			// update active days date in member table
			HttpSession session = request.getSession();
			String memberId = (String) session.getAttribute("MEMBER_ID");
			String role = (String) session.getAttribute("ROLE");
			if("STOCK_POINT".equals(role)) {
				memberId = memberid;
			}
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			//Get order number
			Long orderNumber = Utils.getOrderNumber();
			Purchase purchase = new Purchase();
			Member member =userRepository.findById(memberId).get();
			for(Cart c:cart) {
				// Update qty in product
				Product product = null;
				if("STOCK_POINT".equals(role)) {
					StockPointProduct prod = stockPointProuctRepository.findByCode(c.getCode());
					prod.setQuantity(prod.getQuantity() - c.getQuantity());
					stockPointProuctRepository.save(prod);
					
					//Prepare purchase
					product =new Product();
					product.setCode(prod.getCode());
					product.setProdDesc(prod.getProdDesc());
				} else {
					product = productRepository.findByCode(c.getCode());
					product.setQuantity(product.getQuantity() - c.getQuantity());
					productRepository.save(product);
				}
				preparePurchase(member, orderNumber, purchase, c, product);
			}
			cartRepository.deleteByMemberid(memberId);
			//TODO calculate date and update in DB.
			//member.setActive_days(active_days);
			//userRepository.save(member);
			model.addAttribute("cartList", cart);
			model.addAttribute("orderNumber", orderNumber);
			model.addAttribute("memberId", memberId);
			model.addAttribute("successMessage", "Item Purchased Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseManualConfirmation";
	}

	private void preparePurchase(Member member, Long orderNumber, Purchase purchase, Cart c, Product prod) {
		purchase.setOrderNumber(orderNumber);
		purchase.setAmount(c.getAmount());
		purchase.setMemberid(member.getId());
		if("STOCK_POINT".equals(member.getRole())) {
			purchase.setOrderStatus("PENDING");
		} else {
			purchase.setOrderStatus("APPROVED");
		}
		purchase.setProduct(prod);
		purchase.setQuantity(c.getQuantity());
		purchaseRepository.save(purchase);
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
	
	@RequestMapping(value = "/purchase/manual/review", method = RequestMethod.GET)
	public String purchasemanualReview(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			model.addAttribute("cartList", cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseManualReview";
	}

	@RequestMapping(value = "/purchase/review/edit", method = RequestMethod.GET)
	public String reviewEdit(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			Double total = 0.0;
			if (cart != null) {
				Map<String, Long> map = new HashMap<>();
				for(Cart c: cart) {
					total = total + (c.getQuantity() * c.getAmount());
					map.put(c.getCode(), c.getQuantity());
				};
				model.addAttribute("cartMap", map);
				model.addAttribute("cartTotal", total);
			}
			Iterable<Product> productList = productRepository.findAll();
			model.addAttribute("productList", productList);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseProductList";
	}
	
	@RequestMapping(value = "/purchase/manual/edit", method = RequestMethod.GET)
	public String reviewManualEdit(HttpServletRequest request, ModelMap model) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			List<Cart> cart = cartRepository.findByMemberid(memberId);
			Double total = 0.0;
			if (cart != null) {
				Map<String, Long> map = new HashMap<>();
				for(Cart c: cart) {
					total = total + (c.getQuantity() * c.getAmount());
					map.put(c.getCode(), c.getQuantity());
				};
				model.addAttribute("cartMap", map);
				model.addAttribute("cartTotal", total);
			}
			Iterable<Product> productList = productRepository.findAll();
			model.addAttribute("productList", productList);
			Iterable<Category> catIterable = categoryRepository.findAll();
			model.addAttribute("categoryCodeList", catIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manualPrchase";
	}

	@RequestMapping(value = "/purchase/addToCart", method = RequestMethod.POST)
	public String addTocart(HttpServletRequest request, ModelMap model, @RequestParam("prodCode") String prodCode,
			@RequestParam("qty") String qty) {
		try {
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			Cart existingCart = cartRepository.findByMemberidAndCode(memberId, prodCode);
			if (existingCart != null) {
				existingCart.setQuantity(Long.parseLong(qty));
				cartRepository.save(existingCart);
			} else {
				Product product = productRepository.findByCode(prodCode);
				Cart cart = new Cart();
				cart.setCode(product.getCode());
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
	public ResponseEntity<String> removeFromCarty(HttpServletRequest request, ModelMap model,
			@RequestParam("prodCode") String prodCode) {
		try {
			Long val = cartRepository.deleteByCodeAndMemberid(prodCode, (String) request.getSession().getAttribute("MEMBER_ID"));
			if(val <=0) {
				return new ResponseEntity<String>("No product to remove",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Removed product from cart",HttpStatus.OK);
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
			Iterable<Purchase> purchaseList = purchaseRepository.findByOrderStatus("PENDING");
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

			if (purchase != null && purchase.getId() != null) {
				purchase.setOrderStatus("APPROVED");
				model.addAttribute("successMessage",
						"Order No:" + purchase.getOrderNumber() + " Approved Successfully.");
				purchase = purchaseRepository.save(purchase);
				Iterable<Purchase> purchaseList = purchaseRepository.findByOrderStatus("PENDING");
				model.addAttribute("purchaseList", purchaseList);

			} else {
				model.addAttribute("errorMessage", "Try Again Later!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trasnactionApprove";
	}

}
