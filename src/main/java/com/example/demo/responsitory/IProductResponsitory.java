package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.Products;

public interface IProductResponsitory extends JpaRepository<Products, Integer>{
	@Query("select p from Products p where p.category.id=?1")
	List<Products> findByCategoryId(String cid);
}
