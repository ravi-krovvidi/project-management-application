package com.pma.api.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pma.dao.EmployeeRepository;
import com.pma.entity.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	@Autowired
	EmployeeRepository employRepo;

	@GetMapping
	public Iterable<Employee> getEmployees() {
		return employRepo.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employRepo.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee newEmp) {
		return employRepo.save(newEmp);
	}

	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@RequestBody Employee employ) {
		return employRepo.save(employ);
	}

	@PatchMapping("/{id}")
	public Employee partialUpdateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
		Employee emp1 = employRepo.findById(id).get();
		if (emp.getEmail() != null) {
			emp1.setEmail(emp.getEmail());
		}
		if (emp.getFirstName() != null) {
			emp1.setEmail(emp.getEmail());
		}
		if (emp.getLastName() != null) {
			emp1.setLastName(emp.getLastName());
		}
		return employRepo.save(emp);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") Long id) {
		try {
		employRepo.deleteById(id);
		}
		catch(Exception e) {}
	}
}
