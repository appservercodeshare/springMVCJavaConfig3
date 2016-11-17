package com.spring.mvc.persistence.beans;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTS")
public class ProjectBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proj_id")
	private Long projectId;

	@Column(name = "title")
	private String title;
	
	@Column(name = "desc")
	private String desc;
	
	@Column(name = "role")
	private Role role;
	
	@Column(name = "client")
	private String client;

	@ElementCollection
	@CollectionTable(name = "TECHNOLOGIES", joinColumns = { @JoinColumn(name = "proj_id") })
	private Set<String> technologies;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Set<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<String> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "ProjectBean [projectId=" + projectId + ", title=" + title 
				+ ", desc=" + desc + ", role=" + role + ", client=" 
				+ client + ", technologies=" + technologies + "]";
	}

}
