package com.ttn.reap.controller;

import com.ttn.reap.DTO.EmployeeSearchDTO;
import com.ttn.reap.entity.Employee;
import com.ttn.reap.exception.EmployeeException;
import com.ttn.reap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reap")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/users")
    public List<Employee> fetchAllUsers(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/recog")
    public ResponseEntity<?> fetchRecognizee(@RequestParam String pattern){
        System.out.println("hello");
        List<EmployeeSearchDTO> employees =null;
        try {
            employees = employeeService.findByFirstnameStartingWith(pattern);
            System.out.print(employees.size());
        } catch (EmployeeException e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(e);
        }
        return ResponseEntity.ok().body(employees);
    }
}
