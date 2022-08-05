package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Accounts;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountResponsitory extends JpaRepository<Accounts, String>{
    @Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.id IN ('DIRE','STAF')")
    List<Accounts> getAdministrators();
}
