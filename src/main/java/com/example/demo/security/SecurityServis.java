package com.example.demo.security;

import com.example.demo.model.Company;
import com.example.demo.repository.CompaniesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityServis implements UserDetailsService {

    private final CompaniesRepository companiesRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Company> byName=companiesRepository.findByName(s);
        if (!byName.isPresent()){
            throw new UsernameNotFoundException("company name  not exist");
        }

        return new CurrentUser(byName.get());
    }
}
