package com.cap.main.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cap.main.entity.Customer;
import com.cap.main.entity.Orders;
import com.cap.main.entity.ProductEnt;
import com.cap.main.exception.InvalidUserException;
import com.cap.main.repository.CustomerRepository;
import com.cap.main.repository.OrdersRepository;
import com.cap.main.repository.ProductRepository;



@Service
public class OrdersService {

	@Autowired
	private OrdersRepository erepo;
	@Autowired
	private ProductRepository prpo;
	
	@Autowired
	private CustomerRepository crpo;
	
	
	public void saveProduct(ProductEnt product) {
		erepo.save(product);
		}
	public void saveCustomer(Customer cus) {
		erepo.save(cus);
		}
	public Orders saveorders(Orders or) {
		erepo.save(or);
		return or;
		}
	
	
	public List<Orders> getProducts(){
		return (List<Orders>) erepo.findAll();
	}
	
	
	public Orders getOrdersById(int id) throws InvalidUserException {
		Optional<Orders> op=erepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		throw new InvalidUserException("User Not Found");
	}
	
	
	public String deleteOrderById(int id){
		erepo.deleteById(id);
		return "Order deleted Successfully";
	}
	
	public void update(Orders ord) {
		// TODO Auto-generated method stub
		erepo.save(ord);
		
	}
	
	
	public List<ProductEnt> getPriceInBetween(int sprice,int eprice){
		return erepo.findByPriceBetween(sprice, eprice);
	}
	
	
	public ProductEnt updateProductById( int id,ProductEnt product)
	{
			Optional<ProductEnt> op=prpo.findById(id);
		if(op.isPresent()) {
			ProductEnt pr=op.get();
			pr.setPname(product.getPname());
			pr.setPrice(product.getPrice());
			pr.setQuantity(product.getQuantity());
			prpo.save(pr);
//			return new ResponseEntity<Object>(pr,HttpStatus.OK);
			return pr;
		}
		return null;
	}
	
	
	public Customer updateCustomerById(int id,Customer customer)
	{
		Optional<Customer> op=crpo.findById(id);
		if(op.isPresent()) {
			Customer cus=op.get();
			cus.setCadd(customer.getCadd());
			cus.setCname(customer.getCname());
			crpo.save(cus);
			return cus;
		}
		return null;
	}
	
	public List<Orders> findByorderDate(String odate) {
		return erepo.findByorderDate(odate);
	}
	 
	public ProductEnt findByName(String pname) {
		return prpo.findByName(pname);
	}

	public List<ProductEnt> findAllOrderByPriceDesc(){
		return prpo.findAllOrderByPriceDesc();
	}
	
	public List<ProductEnt> findAllOrderByPriceAsc(){
		return prpo.findAllOrderByPriceAsc();
	}
	
	public int findAllcustomers() {
		 return crpo.findAllcustomers();
	 }
	
	public int findAllorders() {
		 return erepo.findAllorders();
	 }
	
	public List<ProductEnt> findAllProductName(){
		return prpo.findAllProductName();
	}
	
	public List<Orders> getByDateDesc(){
		return erepo.getByDateDesc();
	}
	
}
