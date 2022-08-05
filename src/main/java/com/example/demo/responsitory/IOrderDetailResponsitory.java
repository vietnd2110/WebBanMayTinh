package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.OrderDetail;

public interface IOrderDetailResponsitory extends JpaRepository<OrderDetail, Integer>{

}
