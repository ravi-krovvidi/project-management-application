package com.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pma.dao.ProjectRepository;
import com.pma.dto.ChartData;
import com.pma.entity.Project;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> projectstagecount(){
		return proRepo.getProjectStageCount();
	}
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
}
