package com.example.demo.controlier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlier {

    @GetMapping("/")
    public String main(){
        return "index";
    }


}
