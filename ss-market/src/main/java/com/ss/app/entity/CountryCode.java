package com.ss.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ss.generator.DefaultCountryCodeGenerator;

@Entity
@Table(name = "t_country_code")
public class CountryCode {

	@Id
	@GenericGenerator(name = "country_code_generator", strategy = "com.ss.generator.DefaultCountryCodeGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultCountryCodeGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultCountryCodeGenerator.defaultSsequenceIncrement) })
	@GeneratedValue(generator = "country_code_generator")
	private String id;
	private String countryCode;
	private String countryDesc;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryDesc() {
		return countryDesc;
	}
	public void setCountryDesc(String countryDesc) {
		this.countryDesc = countryDesc;
	}



}
