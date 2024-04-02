package com.cydeo.controller;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        List<String> states = Arrays.asList("Canada", "Alaska","Chicago");
        model.addAttribute("states", states);
        //return "employee/employee-create-mine";
        return "employee/employee-create";
    }
}
