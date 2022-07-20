package com.praveen.training.salesmanager.service;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.training.salesmanager.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor executted");
	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overloaded constructor executted");
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter inection executted");
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();		
	}
}
