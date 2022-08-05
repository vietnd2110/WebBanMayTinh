package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Accounts;

import java.util.List;

@Service
public interface AccountService {

	Accounts findById(String username);
	public List<Accounts> findAll();
	public List<Accounts> getAdministrators();
	
}
