package com.example.demo.rest.controller;

import com.example.demo.bean.Roles;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RolesRestController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Roles> getAll(){
        return roleService.findAll();
    }
}
