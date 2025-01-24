package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/student-form")
    public String showForm(Model model){

        // create a student object
        Student student = new Student();

        // add the student object to the model
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processStudentForm(@ModelAttribute("student") Student student){

        // log the input data
        System.out.println("student: " + student.getFirstName() + student.getLastName());

        return "student-confirmation";
    }
}
