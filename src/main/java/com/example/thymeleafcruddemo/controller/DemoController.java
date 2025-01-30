package com.example.thymeleafcruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/leaders")
    public String leaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String systems(){
        return "systems";
    }
}
