package com.praveen.training.salesmanager.service;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.praveen.training.salesmanager.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	//@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overloaded constructor executed");
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeServiceImpl() {
		System.out.println("Default constructor executted");
	}
	
	public EmployeeRepository getEmployeeRepository(){
		return employeeRepository;
	}
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter executed");
		this.employeeRepository = employeeRepository;
	}


	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();		
	}
}
