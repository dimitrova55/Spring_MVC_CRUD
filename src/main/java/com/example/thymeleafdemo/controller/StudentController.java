package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    // We will use this to trim Strings
    // Remove leading and trailing white space
    // If String only has white spaces, trim it to null
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/student-form")
    public String showForm(Model model){

        // create and add the student object to the model
        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processStudentForm(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "student-form";
        }

        // log the input data
        System.out.println("student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
