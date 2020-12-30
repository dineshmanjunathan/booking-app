package com.ss.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ss.generator.DefaultMemberIDGenerator;
import com.ss.generator.DefaultReferenceCodeGenerator;

@Entity
@Table(name = "t_member")
public class Member implements Serializable {

	@Id
	@GenericGenerator(name = "memberid_generator", strategy = "com.ss.generator.DefaultMemberIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultMemberIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultMemberIDGenerator.defaultSsequenceIncrement) })
	@GeneratedValue(generator = "memberid_generator")
	private String id;
	private String name;
	private String dob;
	private String gender;
	private String email;
	private String phonenumber;
	private String password;
	private String wallet;

	@GenericGenerator(name = "referencecode_generator", strategy = "com.ss.generator.DefaultReferenceCodeGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultReferenceCodeGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultReferenceCodeGenerator.defaultSsequenceIncrement) })
	@GeneratedValue(generator = "referencecode_generator")
	private String referencecode;

	private String createon;
	private String updatedon;
	private String referedby;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getReferencecode() {
		return referencecode;
	}

	public void setReferencecode(String referencecode) {
		this.referencecode = referencecode;
	}

	public String getCreateon() {
		return createon;
	}

	public void setCreateon(String createon) {
		this.createon = createon;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getReferedby() {
		return referedby;
	}

	public void setReferedby(String referedby) {
		this.referedby = referedby;
	}

}
