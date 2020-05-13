package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.repository.EmployeeRepository;
import com.test.repository.RemoteEmployeeRepository;

@SpringBootApplication
public class WebclientMicroserviceServerApplication extends SpringBootServletInitializer {
	
	public static final String EMPLOYEES_SERVICE_URL = "http://employeeService:8080";
	
	public static void main(String[] args) {
		SpringApplication.run(WebclientMicroserviceServerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public EmployeeRepository employeeRepository(){
		return new RemoteEmployeeRepository(EMPLOYEES_SERVICE_URL);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(WebclientMicroserviceServerApplication.class);
	}
}
