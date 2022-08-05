package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Categories;

public interface ICategoryResponstiory extends JpaRepository<Categories, String>{

}
