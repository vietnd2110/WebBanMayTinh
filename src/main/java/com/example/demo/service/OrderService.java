package com.example.demo.service;

 

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Orders;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public interface OrderService {
	
	Orders create(JsonNode orderData);

	Orders findById(Integer id);

	List<Orders> findByUsername(String username);

	 
}
