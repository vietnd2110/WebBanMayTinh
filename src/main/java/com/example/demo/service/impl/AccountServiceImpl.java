package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Accounts;
import com.example.demo.responsitory.IAccountResponsitory;
import com.example.demo.service.AccountService;

import java.util.List;

@Service
	public class AccountServiceImpl implements AccountService {
	@Autowired
	IAccountResponsitory responsitory;

	public AccountServiceImpl(IAccountResponsitory responsitory) {
		super();
		this.responsitory = responsitory;
	}

	@Override
	public Accounts findById(String username) {
		return responsitory.findById(username).get();
	}

	public List<Accounts> findAll() {
		return responsitory.findAll();
	}

	public List<Accounts> getAdministrators() {
		return responsitory.getAdministrators();
	}
}
