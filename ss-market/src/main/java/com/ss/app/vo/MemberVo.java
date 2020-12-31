package com.ss.app.vo;

import java.sql.Date;

public class MemberVo {

	private Long id;
	private String member_id;
	private String name;
	private Date dob;
	private String gender;
	private String email;
	private Long phonenumber;
	private String password;
	private Long walletBalance = 0L;
	private Long walletWithdrawn= 0L;
	private String referencecode;
	private Date createon;
	private Date updatedon;
	private String referedby;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Long walletBalance) {
		this.walletBalance = walletBalance;
	}
	public Long getWalletWithdrawn() {
		return walletWithdrawn;
	}
	public void setWalletWithdrawn(Long walletWithdrawn) {
		this.walletWithdrawn = walletWithdrawn;
	}
	public String getReferencecode() {
		return referencecode;
	}
	public void setReferencecode(String referencecode) {
		this.referencecode = referencecode;
	}
	public Date getCreateon() {
		return createon;
	}
	public void setCreateon(Date createon) {
		this.createon = createon;
	}
	public Date getUpdatedon() {
		return updatedon;
	}
	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}
	public String getReferedby() {
		return referedby;
	}
	public void setReferedby(String referedby) {
		this.referedby = referedby;
	}
	
	
	
}
