package com.example.demo;

import com.example.demo.model.Company;
import com.example.demo.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompanyEmployApplication implements CommandLineRunner {
    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(CompanyEmployApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        if(!companiesRepository.findByName("poxos").isPresent()){
            companiesRepository.save(Company.builder()
                    .name("poxos")
                    .size(27)
                    .address("Gyumri")
                    .password(passwordEncoder.encode("poxos"))
                    .build());
        }
    }
}
