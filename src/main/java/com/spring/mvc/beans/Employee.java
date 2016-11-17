package com.spring.mvc.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


public class Employee {

	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date joiningDate;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date releaseDate;
	private List<String> skills;
	private Integer experience;
	private Double salary;
	private Double annualPkg;
	private Map<String, String> contacts;
	private Map<String, Address> addresses;
	private Set<Project> projects;
	private MultipartFile profile;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String gender, Date joiningDate, Date releaseDate,
			List<String> skills, Integer experience, Double salary, Double annualPkg, Map<String, String> contacts,
			Map<String, Address> addresses, Set<Project> projects, MultipartFile profile) {

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
		this.profile = profile;
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", joiningDate="
				+ joiningDate + ", releaseDate=" + releaseDate + ", skills=" + skills 
				+ ", experience=" + experience + ", salary=" + salary + ", annualPkg=" 
				+ annualPkg + ", contacts=" + contacts + ", addresses=" + addresses 
				+ ", projects=" + projects + ", profile=" + profile + "]";
	}

}
