package com.praveen.training.salesmanager;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.praveen.training.salesmanager.config.ApplicationConfiguration;
import com.praveen.training.salesmanager.model.Employee;
import com.praveen.training.salesmanager.service.EmployeeService;

public class Applicaition {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);

		System.out.println(employeeService.toString());

		EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);

		List<Employee> employees = employeeService.getAllEmployees();

		for (Employee employee : employees) {
			System.out.print(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());
		}
	}
}
