package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.dto.ChartData;
import com.pma.dto.EmployeeProject;
import com.pma.entity.Employee;
import com.pma.entity.Project;
import com.pma.services.EmployeeService;
import com.pma.services.ProjectService;

@Controller
public class HomeController {
	@Autowired
	ProjectService proServ;
	@Autowired
	EmployeeService employeeServ;
	
	@Value(value = "${version:default value}")
	private String version;
	
	
	
	@GetMapping(value= {"/home","/"})
	public String displayHome(Model model) throws JsonProcessingException {
		
		List<Project> projects = proServ.getAll();
		model.addAttribute("projectsList", projects);
		model.addAttribute("version",version);
		
		List<ChartData> data =  proServ.projectstagecount(); 
		//so that javascript can use it 
		ObjectMapper object= new ObjectMapper();
		String jsonString = object.writeValueAsString(data);
		model.addAttribute("projectStageCount", jsonString);
		
		List<EmployeeProject> employees =  employeeServ.employeeProjects();
		model.addAttribute("employeesProjectList", employees);
		return "main/home";
	}
}
