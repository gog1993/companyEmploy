package com.example.demo.controlier;

import com.example.demo.model.Company;
import com.example.demo.repository.CompaniesRepository;
import com.example.demo.repository.EmployRepasitory;
import com.example.demo.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class EmployControleer {


    @Autowired
    private EmployRepasitory employRepasitory;
    private CompaniesRepository companiesRepository;

    @GetMapping("/employees")
    public String employ(ModelMap modelmap) {
        List <Employe> all = employRepasitory.findAll();
        modelmap.addAttribute("employees", all);
        return "employees";
    }

    @GetMapping("/addEmployees")
    public String addEmployees(ModelMap modelMap) {
        List<Company> all= companiesRepository.findAll();
        modelMap.addAttribute("companies", all);
        return "addEmployees";
    }


    @PostMapping("/addEmployees")
    public String addEmployees(@ModelAttribute Employe employees) {
        employRepasitory.save(employees);
        return "redirect:/addEmployees";
    }
}
