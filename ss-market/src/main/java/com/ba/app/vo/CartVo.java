package com.ba.app.vo;

import java.time.LocalDateTime;

public class CartVo {

	private Long id;
	private String memberid;
	private String code;
	private String prodDesc;
	private Double amount;
	private Long quantity;
	private LocalDateTime purchasedon;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getPurchasedon() {
		return purchasedon;
	}
	public void setPurchasedon(LocalDateTime purchasedon) {
		this.purchasedon = purchasedon;
	}
	
}
