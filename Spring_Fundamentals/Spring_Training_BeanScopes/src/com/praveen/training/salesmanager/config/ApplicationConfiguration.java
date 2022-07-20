package com.praveen.training.salesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import com.praveen.training.salesmanager.repository.EmployeeRepository;
import com.praveen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.praveen.training.salesmanager.service.EmployeeService;
import com.praveen.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@Component("com.praveen")
@PropertySource("application.yml")
public class ApplicationConfiguration {

	@Bean(value = "employeeService")
	//@Scope("Singleton") //singleton scope
	@Scope("prototype") //prototype scope
	public EmployeeService getemployeeService() {

		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

//	@Bean(value = "employeeRepository")
//	public EmployeeRepository getEmployeeRepository() {
//		return new HibernateEmployeeRepositoryImpl();
//	}

}
