package com.example.demo.service.impl;

import com.example.demo.bean.Accounts;
import com.example.demo.bean.Authorities;
import com.example.demo.responsitory.IAccountResponsitory;
import com.example.demo.responsitory.IAuthorityRespronsitory;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    IAuthorityRespronsitory authorityRespronsitory;

    @Autowired
    IAccountResponsitory accountResponsitory;

    public List<Authorities> findAll() {
        return authorityRespronsitory.findAll();
    }

    public Authorities create(Authorities auth) {
        return authorityRespronsitory.save(auth);
    }

    public void delete(Integer id) {
        authorityRespronsitory.deleteById(id);
    }

    public List<Authorities> findAuthoritiesOfAdministrators() {
        List<Accounts> accounts = accountResponsitory.getAdministrators();
        return authorityRespronsitory.authoritiesOf(accounts);
    }

    @Override
    public Authorities save(Authorities auth) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        authorityRespronsitory.deleteById(id);
    }

    @Override
    public List<Authorities> authoritiesOf(List<Accounts> accounts) {
        return null;
    }
}
