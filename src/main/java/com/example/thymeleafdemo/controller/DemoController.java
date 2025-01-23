package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("date", java.time.LocalDateTime.now());

        return "helloworld";
    }

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    /*
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    */

    /*
    @RequestMapping("/processForm")
    public String processFormVersionTwo(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        String result = "Heyy " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }

     */

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String name, Model model){

        name = name.toUpperCase();
        String result = "Heyy my Friend " + name;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
