package com.iris.dao;

import java.util.List;

import com.iris.models.Configuration;
import com.iris.models.ProjectAllocation;
import com.iris.models.Projects;



public interface ProjectsDao {
	
	
	public List<Projects> getAllProject();
	public List<Configuration> getAllConfig();
	
	public Projects getProjectById(int projectId);
	public boolean setProjectConfig(Configuration pObj);
	public List<Configuration> validateProject(int projectId,int roleId,String loc) ;
	public  boolean  setProjectAllocation(ProjectAllocation projectAllocation);	
	public List<ProjectAllocation> getAllProjectAllocation();
	
	public List<Configuration> getAllConfig(int projectId);
}
