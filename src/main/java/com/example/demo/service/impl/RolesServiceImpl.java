package com.example.demo.service.impl;

import com.example.demo.bean.Roles;
import com.example.demo.responsitory.IRoleResponsitory;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RoleService{
    @Autowired
    IRoleResponsitory roleResponsitory;

    public List<Roles> findAll(){
        return roleResponsitory.findAll();
    }
}
