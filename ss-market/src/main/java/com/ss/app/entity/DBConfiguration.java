package com.ss.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ss_configuration")
public class DBConfiguration {

	@Id
	@Column(name = "id")
	private String code;
	private String description;
	private String commant;
	private Double value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommant() {
		return commant;
	}

	public void setCommant(String commant) {
		this.commant = commant;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
