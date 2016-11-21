package com.spring.daos.impls;

import org.springframework.stereotype.Repository;

import com.spring.daos.AbstractDao;
import com.spring.daos.EmployeeDao;
import com.spring.persistence.beans.EmployeeBean;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	@Override
	public EmployeeBean addEmployee(EmployeeBean employeeBean) {
		save(employeeBean);
		return employeeBean;
	}

	@Override
	public void updateEmployee(EmployeeBean employeeBean) {
		update(employeeBean);
	}

	@Override
	public void saveOrUpdateEmployee(EmployeeBean employeeBean) {
		saveOrUpdate(employeeBean);
	}
	
	@Override
	public void delete(EmployeeBean employeeBean) {
		delete(employeeBean);
	}
}