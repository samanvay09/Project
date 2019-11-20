package com.iris.models;

public class Configuration {

private int ConfigId;
private String Loc;
private int perhourbilling;
Projects ProjectId;
Roles RoleId;
public int getConfigId() {
	return ConfigId;
}
public void setConfigId(int configId) {
	ConfigId = configId;
}
public String getLoc() {
	return Loc;
}
public void setLoc(String loc) {
	Loc = loc;
}
public int getPerhourbilling() {
	return perhourbilling;
}
public void setPerhourbilling(int perhourbilling) {
	this.perhourbilling = perhourbilling;
}
public Projects getProjectId() {
	return ProjectId;
}
public void setProjectId(Projects projectId) {
	ProjectId = projectId;
}
public Roles getRoleId() {
	return RoleId;
}
public void setRoleId(Roles roleId) {
	RoleId = roleId;
}



}
