package com.spring.mvc.persistence.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long employeeId;
	
	@Column(name = "f_nm")
	private String firstName;
	
	@Column(name = "l_nm")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "join_dt")
	private Date joiningDate;
	
	@Column(name = "release_dt")
	private Date releaseDate;
	
	///////////////
	private List<String> skills;
	
	@Column(name = "experience")
	private Integer experience;
	
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "annual_pkg")
	private Double annualPkg;
	
	@ElementCollection
	@CollectionTable(name = "CONTACTS", joinColumns = {@JoinColumn(name = "emp_id")})
	@MapKeyColumn(name = "contact_type")
	@Column(name = "contact")
	private Map<String, String> contacts;
	
	@ElementCollection
	@CollectionTable(name = "ADDRESSES", joinColumns = {@JoinColumn(name = "emp_id")})
	@MapKeyColumn(name = "address_type")
	@Column(name = "address")
	private Map<String, Address> addresses;
	
	@OneToMany
	@JoinColumn(name = "emp_id")
	private Set<ProjectBean> projects;
	
	@Column(name = "profile_path")
	private String profilePath;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(String firstName, String lastName, String gender, Date joiningDate, Date releaseDate,
			List<String> skills, Integer experience, Double salary, Double annualPkg, Map<String, String> contacts,
			Map<String, Address> addresses, Set<ProjectBean> projects, String profilePath) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.releaseDate = releaseDate;
		this.skills = skills;
		this.experience = experience;
		this.salary = salary;
		this.annualPkg = annualPkg;
		this.contacts = contacts;
		this.addresses = addresses;
		this.projects = projects;
		this.profilePath = profilePath;
	}
	
	public EmployeeBean(Long employeeId, String firstName, String lastName, String gender, Date joiningDate, Date releaseDate,
			List<String> skills, Integer experience, Double salary, Double annualPkg, Map<String, String> contacts,
			Map<String, Address> addresses, Set<ProjectBean> projects, String profilePath) {

		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.releaseDate = releaseDate;
		this.skills = skills;
		this.experience = experience;
		this.salary = salary;
		this.annualPkg = annualPkg;
		this.contacts = contacts;
		this.addresses = addresses;
		this.projects = projects;
		this.profilePath = profilePath;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, String> contacts) {
		this.contacts = contacts;
	}

	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, Address> addresses) {
		this.addresses = addresses;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getAnnualPkg() {
		return annualPkg;
	}

	public void setAnnualPkg(Double annualPkg) {
		this.annualPkg = annualPkg;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Set<ProjectBean> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectBean> projects) {
		this.projects = projects;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	@Override
	public String toString() {
		return "EmployeeBean [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender 
				+ ", joiningDate=" + joiningDate + ", releaseDate=" + releaseDate 
				+ ", skills=" + skills + ", experience=" + experience + ", salary=" + salary 
				+ ", annualPkg=" + annualPkg + ", contacts=" + contacts + ", addresses=" + addresses 
				+ ", projects=" + projects + ", profilePath=" + profilePath + "]";
	}
	
}
