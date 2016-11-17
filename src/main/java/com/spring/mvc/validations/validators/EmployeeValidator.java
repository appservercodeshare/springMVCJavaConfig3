package com.spring.mvc.validations.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.mvc.beans.Employee;
import com.spring.mvc.utils.Utils;

public class EmployeeValidator implements Validator {

	private String errorStatus;

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		setErrorStatus(Utils.validateEmployee(command, errors));
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	@Override
	public String toString() {
		return "EmployeeValidator [errorStatus=" + errorStatus + "]";
	}

}