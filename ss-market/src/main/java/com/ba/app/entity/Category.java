package com.ba.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_category")
public class Category {

	@Id
	private String code;
	private String description;
	@Column(columnDefinition="bigint default 0")
	private long activedays;

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

	public long getActivedays() {
		return activedays;
	}

	public void setActivedays(long activedays) {
		this.activedays = activedays;
	}
}
