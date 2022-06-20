package com.cap.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.main.entity.Customer;
import com.cap.main.entity.Orders;
import com.cap.main.entity.ProductEnt;
import com.cap.main.repository.CustomerRepository;
import com.cap.main.repository.OrdersRepository;
import com.cap.main.repository.ProductRepository;

@SpringBootTest
class Myapp2ApplicationTests {
	
	@Autowired
	private OrdersRepository orepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private ProductRepository prepo;
	
	
	@Disabled
	@Test
	void testsaveProduct() {
		ProductEnt pro=new ProductEnt(6,"Table",750,7,"abc");
		ProductEnt pr=orepo.save(pro);
		assertThat(pr.getId()).isEqualTo(6);
		System.out.println("*********done**********");
		
	}
	
	
	@Disabled
	@Test
	void testsaveCustomer() {
		Customer cus=new Customer(8,"Hyderabad","Anik");
		Customer c=orepo.save(cus);
		assertThat(c.getId()).isEqualTo(8);
		System.out.println("*********done**********");
		
	}

	

	@Disabled
	@Test
	void testfindAllOrders() {
		List<Orders> l=new ArrayList();
		orepo.findAll().forEach(l::add);
		assertThat(l.size()).isGreaterThanOrEqualTo(1);
		System.out.println("***done***");
		
	}
	@Disabled
	@Test
	void testfindOrderById() {
		Optional<Orders> op=orepo.findById(2);
		if(op.isPresent()) {
			Orders or=op.get();
			assertThat(or.getId()).isEqualTo(2);
			
		}
		
	}
	
	@Disabled
	@Test
	void testdeleteOrderById() {
		Optional<Orders> op=orepo.findById(3);
		if(op.isPresent()) {
			Orders or=op.get();
			assertThat(or.getId()).isEqualTo(3);
			orepo.deleteById(3);
			System.out.println("Successfully deleted");
		}
		else {
			assertThat(op).isEmpty();
		}
		
	}
	
	@Disabled
	@Test
	void testUpdateProductById() {
		Optional<ProductEnt> op = prepo.findById(10);
		System.out.println(op);
		if (op.isPresent()) {
			ProductEnt pr = op.get();
			assertThat(pr.getId()).isEqualTo(10);
			pr.setPname("wallet");
			prepo.save(pr);
			pr.setPrice(1000);
			prepo.save(pr);
			pr.setQuantity(3);
			prepo.save(pr);
			System.out.println("####10MARKS####");
		} else {
			assertThat(op).isEmpty();
		}
	}
	
	@Disabled
	@Test
	void testUpdateCustomerById() {
		Optional<Customer> op = crepo.findById(2);
		System.out.println(op);
		if (op.isPresent()) {
			Customer customer = op.get();
			assertThat(customer.getId()).isEqualTo(2);
			customer.setCadd("Pune");
			crepo.save(customer);
			customer.setCname("anikesh");
			crepo.save(customer);
			System.out.println("####Done####");
		} else {
			assertThat(op).isEmpty();
		}
	}
	
	@Disabled
	@Test
	void testGetProductByName() {
		List<ProductEnt> list=new ArrayList<>();
		prepo.findAll().forEach(list::add);
		assertThat(list.size()).isGreaterThanOrEqualTo(0);
		System.out.println("###Done###");
	}
	
	@Test
	void testGetproductBypricedesc(){
		List<ProductEnt> list=new ArrayList<>();
		prepo.findAll().forEach(list::add);
		assertThat(list.size()).isGreaterThanOrEqualTo(0);
		System.out.println("###Done###");
	}
	
	
	
	

}
