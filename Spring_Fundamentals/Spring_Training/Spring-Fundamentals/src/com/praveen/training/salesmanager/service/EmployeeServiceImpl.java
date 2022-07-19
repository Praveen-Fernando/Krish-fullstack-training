package com.praveen.training.salesmanager.service;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import com.praveen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

import java.util.List;

import com.praveen.training.salesmanager.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeerepository = new HibernateEmployeeRepositoryImpl();
	
	public List<Employee> getAllEmployees(){
		return employeerepository.getAllEmployees();		
	}
}
