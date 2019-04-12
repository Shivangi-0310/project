package com.ttn.reap.controller;

import com.ttn.reap.DTO.LoggedInUserDetails;
import com.ttn.reap.entity.Employee;
import com.ttn.reap.enums.ExceptionStatus;
import com.ttn.reap.exception.EmployeeException;
import com.ttn.reap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/reap")
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/login")
    public String goToLogin(Model model) {
        model.addAttribute("loggedInUser", new LoggedInUserDetails());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLoginCredentials(@ModelAttribute("loggedInUser") Employee loggedUser,
                              HttpSession session, RedirectAttributes redirectAttributes) throws IOException {

        try {
            Employee employee = employeeService.loginEmployee(loggedUser.getEmail(), loggedUser.getPassword());
            LoggedInUserDetails loggedInUser = new LoggedInUserDetails();
            loggedInUser.setEmail(employee.getEmail());
            loggedInUser.setId(employee.getId());
            loggedInUser.setFirstName(employee.getFirstName());
            loggedInUser.setLastName(employee.getLastName());
            loggedInUser.setProfilePhoto(employee.getProfilePhoto());
            loggedInUser.setGoldBadgeCount(employee.getGoldBadgeCount());
            loggedInUser.setSilverBadgeCount(employee.getSilverBadgeCount());
            loggedInUser.setBronzeBadgeCount(employee.getBronzeBadgeCount());
            loggedInUser.setNoOfGoldBadgeEarned(employee.getNoOfGoldBadgeEarned());
            loggedInUser.setNoOfSilverBadgeEarned(employee.getNoOfSilverBadgeEarned());
            loggedInUser.setNoOfBronzeBadgeEarned(employee.getNoOfBronzeBadgeEarned());
            loggedInUser.setPoints(employee.getPoints());
            loggedInUser.setPassword(employee.getPassword());
            session.setAttribute("loggedInUser", loggedInUser);
            return "redirect:/reap/dashboard";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("isValidCredentilas", false);

            if (e instanceof EmployeeException) {
                redirectAttributes.addFlashAttribute("exception", e);
            }
            else{
                redirectAttributes.addFlashAttribute("exception", new Exception("Can Not login Try again"));
            }
            return "redirect:login";
        }
    }

// used interceptor so no need of this
//    @PostMapping("/logout")
//    public ModelAndView logUserOut(HttpServletRequest httpServletRequest) {
//        HttpSession httpSession = httpServletRequest.getSession();
//        httpSession.invalidate();
//        return new ModelAndView("redirect:login");
//    }

}