package com.example.thymeleafcruddemo.service;

import com.example.thymeleafcruddemo.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
