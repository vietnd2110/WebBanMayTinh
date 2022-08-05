package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.Orders;

public interface IOrderResponsitory extends JpaRepository<Orders, Integer> {
	@Query("select o from Orders o where o.account.username=?1")
	List<Orders> findByUsername(String username);
}
