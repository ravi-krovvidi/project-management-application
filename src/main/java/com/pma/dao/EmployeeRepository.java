package com.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pma.dto.EmployeeProject;
import com.pma.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();

	@Query(nativeQuery = true, value = "select e.first_name as firstName, e.last_name as lastName, "
			+ "count(pe.project_id) as projectCount "
			+ "from employee e join project_employee pe on e.employee_id = pe.employee_id "
			+ "group by e.employee_id order by e.employee_id")
	public List<EmployeeProject> employeeProjectCount();
}
