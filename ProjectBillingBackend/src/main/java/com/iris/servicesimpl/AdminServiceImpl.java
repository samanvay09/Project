package com.iris.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.DeveloperDao;
import com.iris.dao.ProjectsDao;
import com.iris.dao.RolesDao;
import com.iris.models.Attendance;
import com.iris.models.Configuration;
import com.iris.models.Developer;

import com.iris.models.Projects;
import com.iris.models.Roles;
import com.iris.services.AdminService;

@Component
@Service("adminService")
@Transactional

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private ProjectsDao projectsDao;
	
	@Autowired
	private RolesDao rolesDao;
	
	@Autowired
	private DeveloperDao developerDao;
	
	
	public List<Projects> getAllProject()
	{
		return projectsDao.getAllProject();
	}
	
	public List<Roles> getAllRole()
	{
		return rolesDao.getAllRole();
	}
	
	public List<Developer> getAllDeveloper()
	{
		return developerDao.getAllDeveloper();
	}
	
	public List<Configuration> getAllConfig()
	{
		return projectsDao.getAllConfig();
	}
	
	public boolean setProjectConfig(Configuration pObj)
	{
		boolean save = projectsDao.setProjectConfig(pObj);
		return save;
	}
	public Projects getProjectById(int projectId)
	{
		return projectsDao.getProjectById(projectId);
	}
	public Attendance getBill(int developerId, String month,int year)
	{
		return developerDao.getBill(developerId, month,year);
	}
	
	
}
	
	


