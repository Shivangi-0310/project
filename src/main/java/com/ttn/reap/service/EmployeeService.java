package com.ttn.reap.service;

import com.ttn.reap.enums.Badge;
import com.ttn.reap.entity.Employee;
import com.ttn.reap.enums.ExceptionStatus;
import com.ttn.reap.enums.Role;
import com.ttn.reap.exception.EmployeeException;
import com.ttn.reap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //    saving an employee with other internal details into the db while registration!
    public Employee saveEmployee(Employee employee, MultipartFile multipartFile)
            throws IOException, EmployeeException {

        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {

            throw new EmployeeException("Email Already Registered", ExceptionStatus.EMPLOYEE_ALREADY_EXIST);
        }

        employee.setActive(Boolean.TRUE);
        employee.getRoleSet().add(Role.USER);
        setBadges(employee);
        String photoPath = saveProfilePhotoPath(multipartFile);
        employee.setProfilePhoto(photoPath);
        employee.setNoOfBronzeBadgeEarned(0);
        employee.setNoOfSilverBadgeEarned(0);
        employee.setNoOfGoldBadgeEarned(0);
        Integer points = calculatePoints(employee);
        employee.setPoints(points);
        return employeeRepository.save(employee);

    }

    //    setting badges employee are allowed to give based on their roles
    Employee setBadges(Employee employee) {
        if (employee.getRoleSet().contains(Role.PRACTICE_HEAD)) {
            employee.setGoldBadgeCount(9);
            employee.setSilverBadgeCount(6);
            employee.setBronzeBadgeCount(3);
        } else if (employee.getRoleSet().contains(Role.SUPERVISOR)) {
            employee.setGoldBadgeCount(6);
            employee.setSilverBadgeCount(3);
            employee.setBronzeBadgeCount(2);
        } else {
            employee.setGoldBadgeCount(3);
            employee.setSilverBadgeCount(2);
            employee.setBronzeBadgeCount(1);
        }
        return employee;
    }


    //    for calcuting points of employees based on their no of badge earned.
    public Integer calculatePoints(Employee employee) {
        Integer points;
        points = employee.getNoOfGoldBadgeEarned() * Badge.GOLD.getBadgeWeight() +
                employee.getNoOfSilverBadgeEarned() * Badge.SILVER.getBadgeWeight()
                + employee.getNoOfBronzeBadgeEarned() * Badge.BRONZE.getBadgeWeight();

        return points;
    }

    //    for finding all employee for search functionality
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    //    for checking whether the employee is already registered or not....
    //    for registration and login purpose
    //    also for the search functionality
    public Optional<Employee> findEmployeeByEmailId(String email) {
        return employeeRepository.findByEmail(email);
    }

    //    for search functionality
    public Optional<List<Employee>> findEmployeeByFirstName(String firstname) {
        return employeeRepository.findByFirstName(firstname);
    }

    //    for search functionality
    public Optional<List<Employee>> findEmployeeByLastName(String lastname) {

        return employeeRepository.findByLastName(lastname);
    }

    //    for saving profile picture uploaded by the employee while registration
    public String saveProfilePhotoPath(MultipartFile profilePhoto) throws IOException {

        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        String photoPath = currentWorkingDir.toString() + "/src/main/resources/static/emp-imgs/";
        byte[] photoBytes = profilePhoto.getBytes();
        Path path = Paths.get(photoPath + profilePhoto.getOriginalFilename());
        System.out.println(path.toString());
        Files.write(path, photoBytes);
        return "/emp-imgs/" + profilePhoto.getOriginalFilename();
    }


    public Employee loginEmployee(String email, String password) throws EmployeeException {

        Optional<Employee> employee = employeeRepository.findByEmailAndPassword(email, password);
        if (!employee.isPresent()) {
            throw new EmployeeException("Invalid Credentials", ExceptionStatus.INVALID_DETAILS);
        }
        return employee.get();

    }


}