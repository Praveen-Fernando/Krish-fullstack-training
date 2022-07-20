package com.praveen.training.salesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import com.praveen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.praveen.training.salesmanager.service.EmployeeService;
import com.praveen.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@Component("com.praveen")
public class ApplicationConfiguration {

	@Bean(value = "employeeService")
	public EmployeeService getemployeeService() {

		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
	}

//	@Bean(value = "employeeRepository")
//	public EmployeeRepository getEmployeeRepository() {
//		return new HibernateEmployeeRepositoryImpl();
//	}

}
