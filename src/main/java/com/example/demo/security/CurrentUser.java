package com.example.demo.security;
import com.example.demo.model.Company;
import com.zaxxer.hikari.util.FastList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;


import java.util.Collection;

public class CurrentUser extends  org.springframework.security.core.userdetails.User{
    private Company company;


    public CurrentUser(Company company) {
        super(company.getName(), company.getPassword(), AuthorityUtils.createAuthorityList());
        this.company=company;
    }
    public Company getCompany(){
        return company;
    }


}
