package com.spring.services;

import com.spring.persistence.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean addEmployee(EmployeeBean emmployeeBean);
	public void updateEmployee(EmployeeBean employeeBean);
	public void saveOrUpdateEmployee(EmployeeBean employeeBean);
	public void delete(EmployeeBean employeeBean);
}
