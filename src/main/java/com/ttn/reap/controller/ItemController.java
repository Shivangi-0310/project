package com.ttn.reap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/reap")
public class ItemController {
    @RequestMapping("/items")
    public String fetchItems(Model model, HttpSession session) {
        model.addAttribute("loggedInUser",session.getAttribute("loggedInUser"));
        return "Items";
    }
}
