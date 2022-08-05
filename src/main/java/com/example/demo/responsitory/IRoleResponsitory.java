package com.example.demo.responsitory;

import com.example.demo.bean.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleResponsitory extends JpaRepository<Roles, Integer> {
}
