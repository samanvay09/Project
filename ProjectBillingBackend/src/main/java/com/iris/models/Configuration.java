package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Config")
public class Configuration {

	@Id
    @GeneratedValue
    @Column(name="ConfigId")	
private int configId;
	 @Column(name="Loc")	
private String loc;
	 @Column(name="perhourbilling")
private int perHourBilling;
@ManyToOne
@JoinColumn(name="ProjectId")
Projects projectId;
@ManyToOne
@JoinColumn(name="RoleId")
Roles roleId;
public int getConfigId() {
	return configId;
}
public void setConfigId(int configId) {
	this.configId = configId;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
public int getPerHourBilling() {
	return perHourBilling;
}
public void setPerHourBilling(int perHourBilling) {
	this.perHourBilling = perHourBilling;
}
public Projects getProjectId() {
	return projectId;
}
public void setProjectId(Projects projectId) {
	this.projectId = projectId;
}
public Roles getRoleId() {
	return roleId;
}
public void setRoleId(Roles roleId) {
	this.roleId = roleId;
}
@Override
public String toString() {
	return "Configuration [configId=" + configId + ", loc=" + loc + ", perHourBilling=" + perHourBilling
			+ ", projectId=" + projectId + ", roleId=" + roleId + "]";
}



}
