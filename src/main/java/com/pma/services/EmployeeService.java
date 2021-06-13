package com.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pma.dao.EmployeeRepository;
import com.pma.dto.EmployeeProject;
import com.pma.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employRepo;
	
	public Employee save(Employee employee) {
		return employRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return employRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return employRepo.employeeProjectCount();
	}
}
