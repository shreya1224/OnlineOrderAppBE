package com.cap.main.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.main.entity.Customer;
import com.cap.main.entity.Orders;
import com.cap.main.entity.ProductEnt;
import com.cap.main.exception.InvalidUserException;
import com.cap.main.repository.CustomerRepository;
import com.cap.main.repository.OrdersRepository;
import com.cap.main.repository.ProductRepository;
import com.cap.main.service.OrdersService;


@RequestMapping("/ems/")
@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService eservice;
	
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private ProductRepository prpo;
	@Autowired
	private CustomerRepository crpo;
	
	@PostMapping("save")
	public ResponseEntity<String> saveProduct(@RequestBody @Valid Orders or){
		
		System.out.println("Save Product details...");
		System.out.println(or);
		ProductEnt product=or.getPid();
		eservice.saveProduct(product);
		Customer cus=or.getCid();
		eservice.saveCustomer(cus);
		Orders ob=eservice.saveorders(or);
		System.out.println(ob);
		return new ResponseEntity<String>("Successfully stored",HttpStatus.CREATED);
	}
	
	

	@GetMapping("allorders")
	public List<Orders> findAllOrders()
	{
		return eservice.getProducts();
		
	}
	
	
	@GetMapping("getorderbyid/{id}")
	public Orders findOrderById(@PathVariable int id) throws InvalidUserException{
		return eservice.getOrdersById(id);
	}
	
	
	@DeleteMapping("deleteorderbyid/{id}")
	public String deleteOrder(@PathVariable int id) {
		return eservice.deleteOrderById(id);
		
	}

	
	@GetMapping("/getproductpriceinbetween/{sprice}/{eprice}")
	public List<ProductEnt> getProductInRange(@PathVariable("sprice") int sprice,@PathVariable("eprice") int eprice){
		return eservice.getPriceInBetween(sprice, eprice);
		
	}
	
	@PutMapping("/updateorder/{id}")
	public ResponseEntity<Object> updateProductById(@PathVariable("id") int id, @RequestBody Orders orders) {
		Optional<Orders> op = repo.findById(id);
		if (op.isPresent()) {
			Orders ord = op.get();
			ord.setOdate(orders.getOdate());
			ord.getCid().setCname(orders.getCid().getCname());
			ord.getCid().setCadd(orders.getCid().getCadd());
			ord.getPid().setPname(orders.getPid().getPname());
			ord.getPid().setPrice(orders.getPid().getPrice());
			ord.getPid().setQuantity(orders.getPid().getQuantity());
			eservice.update(ord);
			return new ResponseEntity<Object>(ord,HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("NOT FOUND",HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/update/product/{id}")
	public ResponseEntity<Object> updateProductbyId(@PathVariable("id") int id,@RequestBody ProductEnt product)
	{
		if(eservice.updateProductById(id, product)!= null) 
			return new ResponseEntity<Object>("Product updated Successfully",HttpStatus.OK);
			
		return new ResponseEntity<Object>("Id Not Found",HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/update/customer/{id}")
	public ResponseEntity<Object> updateCustomerbyId(@PathVariable("id") int id,@RequestBody Customer customer)
	{
		if(eservice.updateCustomerById(id, customer)!= null) 
			return new ResponseEntity<Object>("Customer updated Successfully",HttpStatus.OK);
			
		return new ResponseEntity<Object>("Id Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	
	@GetMapping("/getorderbyDate/{odate}")
	public ResponseEntity<Object> getorderDate(@PathVariable("odate") String odate){
		List<Orders> op = eservice.findByorderDate(odate);
		if(!op.isEmpty()) {
			return new ResponseEntity<Object>(op,HttpStatus.OK);
		}else {
		 
			return new ResponseEntity<Object>("Failure to get the data",HttpStatus.NOT_FOUND);
		}
	

	}
	
	
	
	@GetMapping("/getproductname/{pname}")
	public ProductEnt getProductByName1(@PathVariable("pname")String pname) {
		return eservice.findByName(pname);
	}
	
	
	
	@GetMapping("/getproductpricedesc")
	public List<ProductEnt> getproductBypricedesc() {
		return eservice.findAllOrderByPriceDesc();
	}
	
	
	@GetMapping("/getproductpriceasc")
	public List<ProductEnt> getproductBypriceasc() {
		return eservice.findAllOrderByPriceAsc();
	}
	 
	@GetMapping("/gettotalcustomer")
	public int gettotalcustomer() {
		return eservice.findAllcustomers();
		}
	
	@GetMapping("/gettotalorders")
	public int gettotalorders() {
		return eservice.findAllorders();
		}
	
	
	@GetMapping("/getproductnameasc")
	public List<ProductEnt> findAllProductName() {
		return eservice.findAllProductName();
	}
	
	
	@GetMapping("/getdatedesc")
	public List<Orders> getByDateDesc() {
		return eservice.getByDateDesc();
	}
	
	
	
}	
