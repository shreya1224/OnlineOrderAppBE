package com.cap.main.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cap.main.entity.Customer;
import com.cap.main.entity.Orders;
import com.cap.main.entity.ProductEnt;




public interface OrdersRepository extends CrudRepository<Orders, Integer>{

	ProductEnt save(ProductEnt product);
	Customer save(Customer cus);
	Orders save(Order or);
	@Query(value="select p from ProductEnt p where p.price between:sprice and :eprice")
	public List<ProductEnt> findByPriceBetween(@Param("sprice") int sprice,@Param("eprice") int eprice);
	
	@Query(value="select count(*) from orders",nativeQuery=true)
	int findAllorders();
	
	@Query(value="select * from Orders o order by o.odate desc",nativeQuery=true)
	List<Orders> getByDateDesc();
	
	@Query(value="select * from Orders o where o.odate=?1",nativeQuery=true)
	List<Orders> findByorderDate(String odate);
	
	
	
	
	
	
}
