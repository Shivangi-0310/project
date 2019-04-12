package com.ttn.reap.event;

import com.ttn.reap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    @Autowired
    EmployeeRepository employeeRepository;

    @EventListener(ContextRefreshedEvent.class)
    void setUp(){
    }


}