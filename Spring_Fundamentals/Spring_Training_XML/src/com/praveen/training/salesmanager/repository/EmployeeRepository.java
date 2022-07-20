package com.praveen.training.salesmanager.repository;

import java.util.List;

import com.praveen.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}