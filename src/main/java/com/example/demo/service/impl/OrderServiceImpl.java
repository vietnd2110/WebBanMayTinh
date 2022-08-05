package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.bean.OrderDetail;
import com.example.demo.bean.Orders;
import com.example.demo.responsitory.IOrderDetailResponsitory;
import com.example.demo.responsitory.IOrderResponsitory;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private IOrderResponsitory responsitory;
	@Autowired
	private IOrderDetailResponsitory responsitory2;
	public OrderServiceImpl(IOrderResponsitory responsitory) {
		super();
		this.responsitory = responsitory;
	}

	
	@Override
	public Orders create(JsonNode orderData) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();

		Orders order = mapper.convertValue(orderData, Orders.class);
		responsitory.save(order);

	TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>(){};
	List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
			.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
	responsitory2.saveAll(details);
	return order;
	}


	
	@Override
	public Orders findById(Integer id) {
		return responsitory.findById(id).get();
	}


	@Override
	public List<Orders> findByUsername(String username) {
		// TODO Auto-generated method stub
		return responsitory.findByUsername(username);
	}
	
}
