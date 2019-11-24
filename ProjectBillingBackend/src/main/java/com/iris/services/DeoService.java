package com.iris.services;

import java.util.List;

import com.iris.models.Attendance;
import com.iris.models.Developer;
import com.iris.models.Projects;

public interface DeoService {
	
	public List<Developer> getAllDeveloper();
	public boolean setAttendance(Attendance dataObj);
	public List<Projects> getAllProject();

}
