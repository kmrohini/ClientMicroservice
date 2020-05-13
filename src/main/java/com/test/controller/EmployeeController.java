/**
 * 
 */
package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/viewEmployees")
	public String employeeList(Model model) {
		model.addAttribute("employeeList", employeeRepository.getAllEmployees());
		return "viewEmployee";
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String addEmployeeToDB(@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String emailId,Model model) {
		employeeRepository.addEmployee(new Employee(firstName, lastName, emailId));
		model.addAttribute("message", "Employee added succesfully");
		return "addEmployee";
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("message", "");
		return "addEmployee";
	}
}
