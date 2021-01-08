package com.ss.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_stock_point_purchase")
public class StockPointPurchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String stockPointId; // MEMBER ID

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "category_id")
	private Category categoryCode;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "product_id")
	private Product productCode;
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
