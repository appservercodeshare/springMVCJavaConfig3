package com.spring.daos;

import com.spring.persistence.beans.EmployeeBean;

public interface EmployeeDao {
	public EmployeeBean addEmployee(EmployeeBean employeeBean);
	public void updateEmployee(EmployeeBean employeeBean);
	public void saveOrUpdateEmployee(EmployeeBean employeeBean);
	public void delete(EmployeeBean employeeBean);
}
