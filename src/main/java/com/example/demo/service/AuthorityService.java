package com.example.demo.service;

import com.example.demo.bean.Accounts;
import com.example.demo.bean.Authorities;

import java.util.List;

public interface AuthorityService {
    public List<Authorities> findAll();

    public Authorities create(Authorities auth);

    public void delete(Integer id);

    public List<Authorities> findAuthoritiesOfAdministrators();

    Authorities save(Authorities auth);

    void deleteById(Integer id);

    List<Authorities> authoritiesOf(List<Accounts> accounts);
}
