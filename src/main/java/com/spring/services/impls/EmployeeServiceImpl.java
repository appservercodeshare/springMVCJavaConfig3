package com.spring.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.daos.EmployeeDao;
import com.spring.persistence.beans.EmployeeBean;
import com.spring.services.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public EmployeeBean addEmployee(EmployeeBean employeeBean) {
		return employeeDao.addEmployee(employeeBean);
	}

	@Override
	public void updateEmployee(EmployeeBean employeeBean) {
		employeeDao.updateEmployee(employeeBean);
	}

	@Override
	public void saveOrUpdateEmployee(EmployeeBean employeeBean) {
		employeeDao.saveOrUpdateEmployee(employeeBean);
	}

	@Override
	public void delete(EmployeeBean employeeBean) {
		employeeDao.delete(employeeBean);
	}

}
