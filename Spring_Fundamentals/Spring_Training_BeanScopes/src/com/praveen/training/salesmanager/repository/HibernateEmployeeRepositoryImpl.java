package com.praveen.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.praveen.training.salesmanager.model.Employee;

@Repository("HibernateEmployeeRepositoryImpl")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	@Value("${name}")
	private String employeeName;
	
	@Value("${city}")
	private String employeeCity;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setEmployeeLocation(employeeCity);
		//employee.add(employee);
		return employees;
		
	}

}
