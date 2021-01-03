package com.ss.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_sequence")
public class HibernateSequence  {
	
	@Id
	private int id;
	@Column(name="prefix_value")
	private String prefixvalue;
	@Column(name="next_val")
	private int nextval;
	private int increment;
	
	
    public HibernateSequence(int id, String prefixvalue, int nextval, int increment) {  
        super();  
        this.id = id;  
        this.prefixvalue = prefixvalue;  
        this.nextval = nextval;
        this.increment = increment;  
    }  
    public HibernateSequence() {  
        super();  
    }  
	
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
