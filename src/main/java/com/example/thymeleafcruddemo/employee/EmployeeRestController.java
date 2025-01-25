package com.example.thymeleafcruddemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listAllEmployees(Model model){

        List<Employee> employees = employeeService.findAll();
        System.out.print(employees);

        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/add")
    public String еmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    // add or update new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // employee.setId(0);
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("employeeId") Integer id, Model model){

        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Integer id) {

        Employee tempEmployee = employeeService.findById(id);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}