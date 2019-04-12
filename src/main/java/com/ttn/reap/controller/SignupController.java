package com.ttn.reap.controller;

import com.ttn.reap.entity.Employee;
import com.ttn.reap.exception.EmployeeException;
import com.ttn.reap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/reap")
public class SignupController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/register")
    public String goToSignup() {
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegistration(@ModelAttribute("employee") Employee employee, @RequestParam("profilePic") MultipartFile profilePic,
                                  RedirectAttributes redirectAttributes, HttpSession session) throws IOException {
        System.out.println(employee);
        try {
            if (employeeService.saveEmployee(employee, profilePic) == null){
                redirectAttributes.addFlashAttribute("isRegistered", false);
            }
        } catch (EmployeeException e) {
            redirectAttributes.addFlashAttribute("isRegistered", false);
            redirectAttributes.addFlashAttribute("exception", e);
            return "redirect:register";
        }
        return "successfulsignup";
    }
}
