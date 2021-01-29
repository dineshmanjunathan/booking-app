package com.ss.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_reward_transaction")
public class RewardTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long orderNumber;
	private String memberid;
	private double point;
	private LocalDateTime rewardedOn = LocalDateTime.now();
	private String sponserId;
	private String rewardedMember;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public LocalDateTime getRewardedOn() {
		return rewardedOn;
	}

	public void setRewardedOn(LocalDateTime rewardedOn) {
		this.rewardedOn = rewardedOn;
	}

	public String getSponserId() {
		return sponserId;
	}

	public void setSponserId(String sponserId) {
		this.sponserId = sponserId;
	}

	public String getRewardedMember() {
		return rewardedMember;
	}

	public void setRewardedMember(String rewardedMember) {
		this.rewardedMember = rewardedMember;
	}

}
