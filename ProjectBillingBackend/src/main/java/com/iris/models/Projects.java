package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Projects")
public class Projects {
	
	@Id
   
    @Column(name="ProjectId")
	private int projectId;
	 @Column(name="ProjectName")
	private String projectName;
	 @Column(name="Active")
	private int active;
	 @Column(name="Description")
	private String description;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", active=" + active
				+ ", description=" + description + "]";
	}
	 
	 
	
	

}
