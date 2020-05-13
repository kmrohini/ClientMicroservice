/**
 * 
 */
package com.test.repository;

import java.util.List;

import com.test.entity.Employee;

public interface EmployeeRepository {
	
	List<Employee> getAllEmployees();
	
	void addEmployee(Employee emp);
}
