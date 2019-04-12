package com.ttn.reap.controller;

import com.ttn.reap.entity.Employee;
import com.ttn.reap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reap")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/users")
    public List<Employee> fetchAllUsers(){
        return employeeService.findAllEmployees();
    }



}
