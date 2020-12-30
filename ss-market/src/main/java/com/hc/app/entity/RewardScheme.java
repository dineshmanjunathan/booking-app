package com.hc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reward_scheme")
public class RewardScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "sell_point")
	private double sellpoint;

	@Column(name = "buy_value")
	private double buyvalue;

	@Column(name = "currency_value")
	private double currencyValue;

	@Column(name = "currency_type")
	private String currencyType;

	@Column(name = "scheme_type")
	private String schemeType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSellpoint() {
		return sellpoint;
	}

	public void setSellpoint(double sellpoint) {
		this.sellpoint = sellpoint;
	}

	public double getBuyvalue() {
		return buyvalue;
	}

	public void setBuyvalue(double buyvalue) {
		this.buyvalue = buyvalue;
	}

	public double getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

}
