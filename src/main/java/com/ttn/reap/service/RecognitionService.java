package com.ttn.reap.service;

import com.ttn.reap.entity.Employee;
import com.ttn.reap.repository.EmployeeRepository;
import com.ttn.reap.repository.RecognitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecognitionService {

    @Autowired
    private RecognitionRepository recognitionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

//    public Optional<List<Employee>> searchRecognizee(String name){
//        return employeeRepository.findByName(name);
//    }


}
