package com.iris.dao;

import java.util.List;

import com.iris.models.Attendance;
import com.iris.models.Developer;
import com.iris.models.ProjectAllocation;


public interface DeveloperDao {

	public List<Developer> getAllDeveloper();	
	public List <Developer> developerAllocation(int devId);
	public Developer getDeveloperById(int id);
	public boolean setAttendance(Attendance obj);
	public Attendance getBill(Integer attendId,String month,int year);
	public List<ProjectAllocation> getAllAllocate();
	public ProjectAllocation getConfig(int id);
	public String getDeveloperByIdd(int id);
	public List<Attendance> getAllAttendance();	
	public ProjectAllocation getProAllocation(int id);
	
	
	
}
