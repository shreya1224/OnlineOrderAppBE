package com.cap.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cap.main.entity.ProductEnt;



public interface ProductRepository extends CrudRepository<ProductEnt, Integer> {

	
	@Query(value="select * from Product_Ent p where p.pname=?1",nativeQuery=true)
	ProductEnt findByName(String pname);
	
	@Query(value="select * from Product_Ent p order by p.price desc",nativeQuery=true)
	List<ProductEnt> findAllOrderByPriceDesc();
	
	@Query(value="select * from Product_Ent p order by p.price asc",nativeQuery=true)
	List<ProductEnt> findAllOrderByPriceAsc();
	
	@Query(value="select * from Product_Ent p order by p.pname asc",nativeQuery=true)
	List<ProductEnt> findAllProductName();
}
