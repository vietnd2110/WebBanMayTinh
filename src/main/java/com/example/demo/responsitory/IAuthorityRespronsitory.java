package com.example.demo.responsitory;

import com.example.demo.bean.Accounts;
import com.example.demo.bean.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAuthorityRespronsitory extends JpaRepository<Authorities, Integer> {
    @Query("SELECT DISTINCT a FROM Authorities a WHERE a.account IN ?1")
    List<Authorities> authoritiesOf(List<Accounts> accounts);
}
