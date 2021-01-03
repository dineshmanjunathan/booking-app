package com.ss.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.ss.generator.DefaultMemberIDGenerator;

@Entity
@Table(name = "t_member")
public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	@Id
	@GenericGenerator(name = "memberid_generator", strategy = "com.ss.generator.DefaultMemberIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultMemberIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultMemberIDGenerator.defaultSsequenceIncrement) })
	@GeneratedValue(generator = "memberid_generator")
	private String id;
	private String name;
	private Date dob;
	private String gender;
	private String email;
	private Long phonenumber;
	private String password;
	private Long walletBalance = 0L;
	private Long walletWithdrawn= 0L;
	private String referencecode;
	long millis=System.currentTimeMillis();  
	private Date createon = new Date(millis);
	private Date updatedon = new Date(millis);
	private String referedby;
	
	@Transient
	private Long totalbalance= 0L;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getReferencecode() {
		return referencecode;
	}
	public void setReferencecode(String referencecode) {
		Random random = new Random();
		int randomWithNextInt = random.nextInt();
		this.referencecode = "REF00"+Math.abs(randomWithNextInt);
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
	public Long getWalletWithdrawn() {
		return walletWithdrawn;
	}
	public void setWalletWithdrawn(Long walletWithdrawn) {
		this.walletWithdrawn = walletWithdrawn;
	}

	public Long getTotalbalance() {
		return totalbalance;
	}
	public void setTotalbalance(Long totalbalance) {
		this.totalbalance = totalbalance;
	}

}