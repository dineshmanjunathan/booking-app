package com.ss.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_sequence")
public class HibernateSequence implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	@Id
	private int id;
	@Column(name="prefix_value")
	private String prefixvalue;
	@Column(name="next_val")
	private int nextval;
	private int increment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrefixvalue() {
		return prefixvalue;
	}
	public void setPrefixvalue(String prefixvalue) {
		this.prefixvalue = prefixvalue;
	}
	public int getNextval() {
		return nextval;
	}
	public void setNextval(int nextval) {
		this.nextval = nextval;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	
}
