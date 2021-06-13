package com.pma.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.pma.ProjectManagementApplication;
import com.pma.dao.ProjectRepository;
import com.pma.entity.Project;

//@ContextConfiguration(classes = {ProjectManagementApplication.class})
//@DataJpaTest
@SpringBootTest
@SqlGroup( @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:data.sql","classpath:schema.sql"}))
public class ProjectRepositoryIntegrationTest {
	@Autowired
	ProjectRepository projectRepo;
	
	@Test
	public void ifNewProjectSavedThenSuccessful() {
		Project newPro = new Project("Test Project","COMPLETED	","test desc");
		projectRepo.save(newPro);
		assertEquals(5, projectRepo.findAll().size());
	}
}
