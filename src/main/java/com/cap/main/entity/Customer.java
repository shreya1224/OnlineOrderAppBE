package com.cap.main.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "UserName Should  Not Be Empty!")
	private String cname;
	@NotEmpty(message = "Address Should  Not Be Empty!")
	private String cadd;

	public Customer() {
		super();
	}
	public Customer(int id,@NotEmpty(message="User name should not be empty") String cname,@NotEmpty(message="User Address should not be empty") String cadd) {
		super();
		this.id = id;
		this.cname = cname;
		this.cadd = cadd;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", cname=" + cname + ", cadd=" + cadd + "]";
	}
	
	
	
	
	
}
