package com.cydeo.controller;

import com.cydeo.bootsrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

       // return "employee/employee-create-mine"; // in here there is my basic html file
       return "employee/employee-create";
    }
    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") Employee employee, Model model ){
        //@ModelAttribute is going to capture the objects that is sent from the UI
        employeeService.saveEmployee(employee);
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "redirect:employee/list";
        //redirect use with endpoint not html file
        //with redirect we are using endpoints
    }
    //we create 2 methods, separate method, insertEmployee() and listEmployees() for single responsibility
    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list"; // without redirect we are using html file
    }
}
