package com.praveen.training.salesmanager;

import java.util.List;

import com.praveen.training.salesmanager.model.Employee;
import com.praveen.training.salesmanager.service.EmployeeService;
import com.praveen.training.salesmanager.service.EmployeeServiceImpl;

public class Applicaition {

	public static void main(String[] args) {
		
		EmployeeService empservice = new EmployeeServiceImpl();
		
		List<Employee> employees = empservice.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.print(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());
		}
	}
}
