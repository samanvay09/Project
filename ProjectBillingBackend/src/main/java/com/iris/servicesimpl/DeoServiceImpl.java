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
import com.iris.models.Developer;
import com.iris.models.Projects;
import com.iris.services.DeoService;

@Component
@Service("deoService")
@Transactional
public class DeoServiceImpl implements DeoService{
	
	@Autowired 
	private ProjectsDao projectsDao;
	
	@Autowired 
	private RolesDao roleDao;
	
	@Autowired
	private DeveloperDao developerDao;
	
	public List<Developer> getAllDeveloper()
	{
		return developerDao.getAllDeveloper();
	}
	
	public boolean setAttendance(Attendance dataObj)
	{
		return developerDao.setAttendance(dataObj);
	}
	
	public List<Projects> getAllProject()
	{
		return projectsDao.getAllProject();
	}

}
