package com.iris.services;

import java.util.List;

import com.iris.models.Attendance;
import com.iris.models.Configuration;
import com.iris.models.Developer;
import com.iris.models.ProjectAllocation;
import com.iris.models.Projects;
import com.iris.models.Roles;

public interface AdminService {
	
	public List<Projects> getAllProject();
	public List<Roles> getAllRole();
	public List<Configuration> getAllConfig();
	public List<Developer> getAllDeveloper();
	public Projects getProjectById(int projectId);
	public boolean setProjectConfig(Configuration pObj);
	public Attendance getBill(int developerId, String month,int year);
	public double getBill(double perHourBilling, Attendance deo);
	public List<ProjectAllocation> getAllAllocate();
	public ProjectAllocation getConfig(int id);
	public String getDeveloperByIdd(int id);
	public List<Attendance> getAllAttendance();	
	public String getProjectName(int id);
	
	
	

}
