package com.ss.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ss_id_generator")
public class HibernateSequence  {
	
	@Id
	@Column(name="id",updatable = false)

	private int id;
	@Column(name="prefix_value")
	private String prefixvalue;
	@Column(name="next_val",updatable = false)
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
