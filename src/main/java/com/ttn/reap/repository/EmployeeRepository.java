package com.ttn.reap.repository;

import com.ttn.reap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Optional<Employee> findByEmail(String emailId);

    public Optional<List<Employee>> findByFirstName(String firstname);

    public Optional<List<Employee>> findByLastName(String lastname);

    public Optional<Employee> findByEmailAndPassword(String emailId, String password);

    public Optional<List<Employee>> findByEmailLike(String emailPattern);

//    public Optional<List<Employee>> findByName(@Param("name") String name);
}



