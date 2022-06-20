package com.cap.main.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "date Should  Not Be Empty!")
	private String odate;
	@OneToOne(cascade= CascadeType.REMOVE)
	private Customer cid;
	@OneToOne(cascade= CascadeType.REMOVE)
	private ProductEnt pid;
	
	public Orders() {
		super();
	}

	

	


	public Orders(int id, @NotNull(message = "date Should  Not Be Empty!") String odate, Customer cid, ProductEnt pid) {
		super();
		this.id = id;
		this.odate = odate;
		this.cid = cid;
		this.pid = pid;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public Customer getCid() {
		return cid;
	}

	public void setCid(Customer cid) {
		this.cid = cid;
	}

	public ProductEnt getPid() {
		return pid;
	}

	public void setPid(ProductEnt pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", odate=" + odate + ", cid=" + cid + ", pid=" + pid + "]";
	}

	
	
}
