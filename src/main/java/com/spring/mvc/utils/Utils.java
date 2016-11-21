package com.spring.mvc.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mvc.beans.Address;
import com.spring.mvc.beans.Employee;
import com.spring.mvc.beans.Project;
import com.spring.mvc.beans.Role;
import com.spring.persistence.beans.AddressBean;
import com.spring.persistence.beans.EmployeeBean;
import com.spring.persistence.beans.ProjectBean;
import com.spring.persistence.beans.RoleBean;

public class Utils {

	public static boolean isEmptyOrNull(String value) {
		return value == null || value.trim().length() == 0;
	}
	
	public static boolean isEmptyOrNull(Object obj) {
		return obj == null; 
	}
	
	
	public static boolean isSetElementNullOrEmpty(Set<String> setElements) {
		
		for(String element : setElements) {
			if(!isEmptyOrNull(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isAllProjectFieldNullOrEmpty(Project project) {
		return isEmptyOrNull(project.getClient()) 
		&& isEmptyOrNull(project.getDesc())
		&& isEmptyOrNull(project.getTitle()) 
		&& isRoleEmptyOrNull(project.getRole()) 
		&& isSetElementNullOrEmpty(project.getTechnologies());
	}
	
	
	public static boolean isAnyProjectFieldNullOrEmpty(Project project) {
		return isEmptyOrNull(project.getClient()) 
				|| isEmptyOrNull(project.getDesc())
				|| isEmptyOrNull(project.getTitle()) 
				|| isRoleEmptyOrNull(project.getRole()) 
				|| isSetElementNullOrEmpty(project.getTechnologies());
		
		
			
	}
	
	public static Set<Project> getNonEmptyProjectSet(Set<Project> projects) {
		
		Set<Project> tempProjectSet = new HashSet<>();
		for(Project project : projects) {
			if(!isAllProjectFieldNullOrEmpty(project)) {
				tempProjectSet.add(project);
			}
		}
		
		return tempProjectSet;
	}
	
	
	public static boolean isSetElementNull(Set<?> setElements) {
		
		for(Object element : setElements) {
			if(isEmptyOrNull(element)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isRoleEmptyOrNull(Role role) {
		if(isEmptyOrNull(role)) {
			return true;
		} else if (isEmptyOrNull(role.getRoleName()) 
			&& isEmptyOrNull(role.getResponsiblities())) {
			return true;
		} 
		return false;
	}
	
	public static String validateAddress(Map<String, Address> addresses, String key, Errors errors) {
		
		String error = "";
		
		Address address = addresses.get(key);
		if(!Utils.isEmptyOrNull(address)) {
			String street = address.getStreet();
			String city = address.getCity();
			String state =  address.getState();
			String pin = address.getPin();
			String country =address.getCountry();
			
			if(Utils.isEmptyOrNull(street)) {
				errors.rejectValue("addresses[" + key + "].street", "com.spring.mvc.employee.error.address.street.required");
				error = "error";
			}
			
			if(Utils.isEmptyOrNull(city)) {
				errors.rejectValue("addresses[" + key + "].city", "com.spring.mvc.employee.error.address.city.required");
				error = "error";
			}

			if(Utils.isEmptyOrNull(state)) {
				errors.rejectValue("addresses[" + key + "].state", "com.spring.mvc.employee.error.address.state.required");
				error = "error";
			}

			if(Utils.isEmptyOrNull(pin)) {
				errors.rejectValue("addresses[" + key + "].pin", "com.spring.mvc.employee.error.address.pin.required");
				error = "error";
			}

			if(Utils.isEmptyOrNull(country)) {
				errors.rejectValue("addresses[" + key + "].country", "com.spring.mvc.employee.error.address.country.required");
				error = "error";
			}
			
			
			if(!Utils.isEmptyOrNull(street) && !Utils.isEmptyOrNull(city)
				 && !Utils.isEmptyOrNull(state) && !Utils.isEmptyOrNull(pin)) {
				 boolean streetCity = street.equalsIgnoreCase(city);
				 boolean streetState = street.equalsIgnoreCase(state);
				 boolean streetPin = street.equalsIgnoreCase(pin);
				 boolean streetCountry = street.equalsIgnoreCase(country);
						 
				 if(streetCity || streetState || streetPin ||streetCountry) {
					   errors.rejectValue("addresses[" + key + "].street", "com.spring.mvc.employee.error.address.street.unique.required");
					   error = "error";
				 }
						 
				 boolean cityState = city.equalsIgnoreCase(state);
				 boolean cityPin = city.equalsIgnoreCase(pin);
				 boolean cityCountry = city.equalsIgnoreCase(country);
						 
				 if(cityState || cityPin || cityCountry) {
					 errors.rejectValue("addresses[" + key + "].city", "com.spring.mvc.employee.error.address.city.unique.required");
					 error = "error";
				 }
						 
				 boolean stateCountry = state.equalsIgnoreCase(country);
				 if(stateCountry) {
					 errors.rejectValue("addresses[" + key + "].state", "com.spring.mvc.employee.error.address.state.unique.required");
					 error = "error";
				 }
			}
			
			if(!pin.trim().matches("^\\d{6}$")) {
					errors.rejectValue("addresses[" + key + "].pin", "com.spring.mvc.employee.error.address.pin.invalid");
					error = "error";
			}
		} else {
			error = "error";
		}
		
		return error;
	}
	
	public static String validateProjects(Set<Project> projects, Errors errors) {
		
		Set<Project> tempProjectSet = getNonEmptyProjectSet(projects);
		int index = 0;
		String error = "";
		
		for(Project project : tempProjectSet) {
			
			if(Utils.isEmptyOrNull(project.getTitle())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].title", "com.spring.mvc.employee.error.project.title.required");
				error = "error";
			}
			
			if(Utils.isEmptyOrNull(project.getDesc())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].desc", "com.spring.mvc.employee.error.project.desc.required");
				error = "error";
			}
			
			if(Utils.isEmptyOrNull(project.getClient())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].client", "com.spring.mvc.employee.error.project.client.required");
				error = "error";
			}
			
			if(Utils.isEmptyOrNull(project.getTechnologies())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].technologies", "com.spring.mvc.employee.error.project.technologies.required");
				error = "error";
			}
			
			if(Utils.isEmptyOrNull(project.getRole())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].role.roleName", "com.spring.mvc.employee.error.project.role.rolename.required");
				error = "error";
			}
			 
			if(!Utils.isEmptyOrNull(project.getRole()) && Utils.isEmptyOrNull(project.getRole().getRoleName())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].role.roleName", "com.spring.mvc.employee.error.project.role.rolename.required");
				error = "error";
			}
			
			if(!Utils.isEmptyOrNull(project.getRole()) && Utils.isEmptyOrNull(project.getRole().getResponsiblities())) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projects[" + index + "].role.responsiblities", "com.spring.mvc.employee.error.project.role.responsibilities.required");
				error = "error";
			}
			
			index++;
		} 
		
		return error;
	}
	
	public static String validateEmployee(Object command, Errors errors) {
		Employee employee = (Employee) command;
		String error = "";
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "com.spring.mvc.employee.error.firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "com.spring.mvc.employee.error.lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "com.spring.mvc.employee.error.gender.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "com.spring.mvc.employee.error.salary.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annualPkg", "com.spring.mvc.employee.error.package.required");
		
		if(Utils.isEmptyOrNull(employee.getFirstName()) || Utils.isEmptyOrNull(employee.getLastName()) 
			 || Utils.isEmptyOrNull(employee.getGender())) {
			error = "firstPage";
		}
		
		if(!Utils.isEmptyOrNull(employee.getSalary()) && employee.getSalary() <= 0) {
			errors.rejectValue("salary", "com.spring.mvc.employee.error.salary.required");
			error="firstPage";
		}
			
		if(!Utils.isEmptyOrNull(employee.getAnnualPkg()) && employee.getAnnualPkg() <= 0) {
			errors.rejectValue("annualPkg", "com.spring.mvc.employee.error.package.required");
			error="firstPage";
		}
		
		Double salary = employee.getSalary();
		Double annualPkg = employee.getAnnualPkg();
		
		if(!Utils.isEmptyOrNull(salary) && !Utils.isEmptyOrNull(annualPkg) && (salary * 12 ) > annualPkg) {
			errors.rejectValue("salary", "com.spring.mvc.employee.error.salary.mismatch.with.package");
			errors.rejectValue("annualPkg", "com.spring.mvc.employee.error.package.mismatch.with.salary");
			error="firstPage";
		}
		
		Date joiningDate = employee.getJoiningDate();
		
		if(Utils.isEmptyOrNull(joiningDate)) { 
			errors.rejectValue("joiningDate", "com.spring.mvc.employee.error.joiningDate.required");
			error="firstPage";
		} else if(joiningDate.after(new Date())){
			errors.rejectValue("joiningDate", "com.spring.mvc.employee.error.joiningDate.should.be.in.past");
			error="firstPage";
		}

		List<String> skills = employee.getSkills();
		if(Utils.isEmptyOrNull(skills) || skills.size() == 0) {
			errors.rejectValue("skills", "com.spring.mvc.employee.error.skills.required");
			error="firstPage";
		}
		
		if(employee.getExperience() <= 0) {
			errors.rejectValue("skills", "com.spring.mvc.employee.error.experience.required");
			error="firstPage";
		}
		String error2 = Utils.validateContact(employee.getContacts(), errors);
		if(!Utils.isEmptyOrNull(error2)) {
			error= "firstPage";
		}
		error2 = "";
		
		Map<String, Address> map = employee.getAddresses();
		error2 = Utils.validateAddress(map, "present", errors);
		error2 = Utils.validateAddress(map, "native", errors);
		error2 = Utils.validateProjects(employee.getProjects(), errors);
		error2 = Utils.validateMultipartFile(employee.getProfile(), errors);
		
		if(!Utils.isEmptyOrNull(error)) {
			error="firstPage";
		} else if (!Utils.isEmptyOrNull(error2)) {
			error="secondPage";
		}
		
		return error;
	}
	
	public static String validateContact(Map<String, String> map, Errors errors) {
		
		String contactType = map.get("contactType");
		String contact = map.get("contact");
		String[] contactTypes = {"phone","mobile","fax","email"};
		String error = "";
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contacts['contact']", "com.spring.mvc.employee.error.contact.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contacts['contactType']", "com.spring.mvc.employee.error.contacttype.required");

		if(!Utils.isEmptyOrNull(contactType) && !Utils.isEmptyOrNull(contact)) {
			if("phone".equalsIgnoreCase(contactType)) {
				if(!contact.matches("^\\d{8}$") 
					|| "fax".equalsIgnoreCase(contactType)) {
					errors.rejectValue("contacts['contact']", "com.spring.mvc.employee.error.contact.invalid.phone");
					errors.rejectValue("contacts['contactType']", "com.spring.mvc.employee.error.contacttype.invalid.phone");
					error = "error";
				}
				
			}
			
			if("mobile".equalsIgnoreCase(contactType)) {
				if(!contact.matches("^\\d{10}$")) {
					errors.rejectValue("contacts['contact']", "com.spring.mvc.employee.error.contact.invalid.mobile");
					errors.rejectValue("contacts['contactType']", "com.spring.mvc.employee.error.contacttype.invalid.mobile");
					error = "error";
				}
			}
			
			if("email".equalsIgnoreCase(contactType)) {
				if(!contact.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
					errors.rejectValue("contacts['contact']", "com.spring.mvc.employee.error.contact.invalid.email");
					errors.rejectValue("contacts['contactType']", "com.spring.mvc.employee.error.contacttype.invalid.email");
					error = "error";
				}
				
			}
			
			boolean flag =true;
			for(String tempContactType : contactTypes) {
				if(tempContactType.equalsIgnoreCase(contactType)) {
					flag=false;
				}
			}
			if(flag) {
				errors.rejectValue("contacts['contactType']", "com.spring.mvc.employee.error.contact.invalid");
				error = "error";
			}
		}
		
		return error;
	}
	
	public static String validateMultipartFile(MultipartFile multipartFile, Errors errors) {
		
		String error = "";
		
		if(multipartFile.getSize() == 0) {
			errors.rejectValue("profile", "com.spring.mvc.employee.error.profile.required");
			error = "error";
		}
		
		return error;
	}
	
	
	/**
	 * Converters
	 */
	
	public static EmployeeBean getEmployeeBean(Employee employee) {
		
		EmployeeBean employeeBean = new EmployeeBean();
		
		employeeBean.setAnnualPkg(employee.getAnnualPkg());
		employeeBean.setContacts(employee.getContacts());
		employeeBean.setExperience(employee.getExperience());
		employeeBean.setFirstName(employee.getFirstName());
		employeeBean.setGender(employee.getGender());
		employeeBean.setJoiningDate(employee.getJoiningDate());
		employeeBean.setLastName(employee.getLastName());
		employeeBean.setReleaseDate(employee.getReleaseDate());
		employeeBean.setSalary(employee.getSalary());
		employeeBean.setSkills(employee.getSkills());
		employeeBean.setProfilePath(employee.getProfile().getName());
		
		Set<Project> projectSet = employee.getProjects();
		Set<ProjectBean> projectBeanSet = new LinkedHashSet<ProjectBean>();
		for(Project project : projectSet) {
			projectBeanSet.add(getProjectBean(project));
		}
		employeeBean.setProjects(projectBeanSet);
		
		Map<String, Address> addressMap = employee.getAddresses();
		Map<String, AddressBean> addressBeanMap = new LinkedHashMap<String, AddressBean>();
		for(Map.Entry<String, Address> entry : addressMap.entrySet()) {
			addressBeanMap.put(entry.getKey(), getAddressBean(entry.getValue()));
		}
		employeeBean.setAddresses(addressBeanMap);
		
		return employeeBean;

	}
	
	public static AddressBean getAddressBean(Address address) {
		return (AddressBean) copyBean(new AddressBean(), address);
	}
	
	public static RoleBean getRoleBean(Role role) {
		return (RoleBean) copyBean(new RoleBean(), role);
	}
	
	public static ProjectBean getProjectBean(Project project) {
		ProjectBean projectBean = new ProjectBean();
		projectBean.setClient(project.getClient());
		projectBean.setDesc(project.getDesc());
		projectBean.setTechnologies(project.getTechnologies());
		projectBean.setTitle(project.getTitle());
		projectBean.setRole(getRoleBean(project.getRole()));
		return projectBean;
	}
	
	public static Object copyBean(Object dest, Object source) {
		try {
			BeanUtils.copyProperties(dest, source);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
}