package com.spring.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoleBean implements Serializable {

	@Column(name = "role_nm")
	private String roleName;
	
	@Column(name = "responsiblity")
	private String responsiblities;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getResponsiblities() {
		return responsiblities;
	}

	public void setResponsiblities(String responsiblities) {
		this.responsiblities = responsiblities;
	}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + 
				", responsiblities=" + responsiblities + "]";
	}
	
	

}
