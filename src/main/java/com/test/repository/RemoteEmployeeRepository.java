package com.test.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.test.entity.Employee;


public class RemoteEmployeeRepository implements EmployeeRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteEmployeeRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		Employee[] employees = restTemplate.getForObject(serviceUrl+"/viewEmployee", Employee[].class);
		return Arrays.asList(employees);
	}
	
	@Override
	public void addEmployee(Employee emp) {
		restTemplate.postForObject(serviceUrl+"/addEmployee",emp,String.class);
	}
}
