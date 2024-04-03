package com.cydeo.controller;

import com.cydeo.bootsrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, Model model ){
        //@ModelAttribute is going to capture the objects that is sent from the UI
//Controller should know about the validation, we need tou put @Valid annotation inside the PostMapping method in front of the Employee object
        //Because we are checking the Objects the user is sending us, we need to another interface BindingResult.
        //we need to add this bindingresult as a parameter in our method in wright after Object parameter (Employee)
        //normally order it does not matter in Java, but here it matter, we have to put after Object to check if it is valid or not

        if (bindingResult.hasErrors()) {
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "redirect:/employee/list";
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
