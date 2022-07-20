package com.praveen.training.salesmanager.service;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import java.util.List;
import com.praveen.training.salesmanager.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();		
	}
}
