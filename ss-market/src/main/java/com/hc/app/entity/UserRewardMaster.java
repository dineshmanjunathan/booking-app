package com.hc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_reward_wallet")
public class UserRewardMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="available_points")
	private String availablePoints;
	
	@Column(name="expiry_date")
	private String expiryDate;
	
	@Column(name="redeemed_points")
	private String redeemedPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(String availablePoints) {
		this.availablePoints = availablePoints;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getRedeemedPoints() {
		return redeemedPoints;
	}

	public void setRedeemedPoints(String redeemedPoints) {
		this.redeemedPoints = redeemedPoints;
	}
	
}
