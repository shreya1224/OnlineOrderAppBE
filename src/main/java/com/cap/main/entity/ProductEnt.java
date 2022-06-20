package com.cap.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class ProductEnt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String pname;
	private int price;
	private int quantity;
	@Column(name="cat")
	private String category;
	public ProductEnt() {
		super();
		//System.out.println("Zero-parameterized");
	}
	public ProductEnt(int id, String pname, int price,int quantity,String category) {
		super();
		System.out.println("parameterized const");
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.category=category;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductEnt [id=" + id + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
	
	
	
}
