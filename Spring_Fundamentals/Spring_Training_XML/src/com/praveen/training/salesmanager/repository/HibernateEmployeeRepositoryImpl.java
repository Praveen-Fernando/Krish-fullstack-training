package com.praveen.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import com.praveen.training.salesmanager.model.Employee;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Praveen");
		employee.setEmployeeLocation("Colombo");
		//employee.add(employee);
		return employees;
		
	}

}
