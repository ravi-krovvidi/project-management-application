package com.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pma.dto.ChartData;
import com.pma.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
	@Query(nativeQuery = true,value= "SELECT stage as stage, count(project_id) as projectCount FROM PROJECT group by stage")
	public List<ChartData> getProjectStageCount();
}
