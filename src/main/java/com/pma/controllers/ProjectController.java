package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.entity.Employee;
import com.pma.entity.Project;
import com.pma.services.EmployeeService;
import com.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectService proServ;
	
	@Autowired
	EmployeeService employeeServ;
	
	@GetMapping
	public String listEmployees(Model model) {
		List<Project> projects = proServ.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	@GetMapping("/new")
	public String displayProjectForm(Model model, Project project) {
		List<Employee> allEmployees = employeeServ.getAll();
		model.addAttribute("allEmployees", allEmployees);
		model.addAttribute("project", project);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Model model, Project project) {
		// add the data in project object to database
		proServ.save(project);
		
		
		// redirect is used so avoid duplicate entries
		return "redirect:/projects";
		
	}
}
