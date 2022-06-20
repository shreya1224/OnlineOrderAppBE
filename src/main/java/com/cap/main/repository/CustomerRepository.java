package com.cap.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cap.main.entity.Customer;
import com.cap.main.entity.ProductEnt;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	@Query(value="select count(*) from customer",nativeQuery=true)
	int findAllcustomers();
	
}
