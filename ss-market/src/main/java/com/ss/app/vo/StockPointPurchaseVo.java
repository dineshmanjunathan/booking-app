package com.ss.app.vo;

import com.ss.app.entity.Category;
import com.ss.app.entity.Product;

public class StockPointPurchaseVo {

	private String id;
	private String stockPointId; // MEMBER ID
	private Product productCode;
	private Category categoryCode;
	private Long qty = 0L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(String stockPointId) {
		this.stockPointId = stockPointId;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Category getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Category categoryCode) {
		this.categoryCode = categoryCode;
	}
}
