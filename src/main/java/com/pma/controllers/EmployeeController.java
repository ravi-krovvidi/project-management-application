package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.dao.EmployeeRepository;
import com.pma.entity.Employee;
import com.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employServ;
	@GetMapping
	public String listEmployees(Model model) {
		List<Employee> employees = employServ.getAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(@ModelAttribute("employee") Employee employee) {
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee) {
		employServ.save(employee);
		return "redirect:/employees/new";
	}
	
}
