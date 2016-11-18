package com.spring.persistence.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTS")
public class ProjectBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proj_id")
	private Long projectId;

	@Column(name = "title")
	private String title;
	
	@Column(name = "desc")
	private String desc;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "responsiblity", column = @Column(name = "responsiblities"))})
	private RoleBean role;
	
	@Column(name = "client")
	private String client;

	@ElementCollection
	@CollectionTable(name = "TECHNOLOGIES", joinColumns = { @JoinColumn(name = "proj_id") })
	@Column(name = "technologies")
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

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
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
