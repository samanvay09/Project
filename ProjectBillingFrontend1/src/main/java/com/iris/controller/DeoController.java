package com.iris.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iris.dao.DeveloperDao;
import com.iris.dao.ProjectsDao;
import com.iris.models.Attendance;
import com.iris.models.Configuration;
import com.iris.models.Developer;
import com.iris.models.ProjectAllocation;
import com.iris.models.Projects;
import com.iris.services.DeoService;

@Controller
public class DeoController {
	@Autowired
	private DeoService deoService;
	
	@Autowired
	private DeveloperDao developerDao;
	
	
	@Autowired
	private ProjectsDao projectsDao;
	
	@Autowired
	HttpSession session;
	
	
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null) {
			map.addAttribute("msg","Session doesnt exist.. Login First");
			return true;
		}
		return false;
		
	}
	
	
	@RequestMapping(value= {"/Attendance"},method=RequestMethod.GET)
	public String Allocation(ModelMap map) {
		
		if(checkSession(map)) {
			return "Homepage";
		}
		
		List<Developer> dList = deoService.getAllDeveloper();
		List<Projects> proList =deoService.getAllProject();
		
		Attendance dataObj=new Attendance();
		//ModelAndView mv=new ModelAndView("DEO");
		map.addAttribute("dev", dList);
		map.addAttribute("pro",proList);
		map.addAttribute("dataObj", dataObj);
		
		
		return "Attendance";
	}
	
	
	
	@ResponseBody
	 @RequestMapping(value="/getDeveloperList",method=RequestMethod.GET)
	public List<Developer> getDeveloperById(@RequestParam("projectId")int projectId){
		
		System.out.println("Given project Id : "+projectId);
		List<Developer> deList=new ArrayList<Developer>();
		
		List<Configuration> configList = projectsDao.getAllConfig(projectId);
		System.out.println(configList);
		List<ProjectAllocation> allocationList = projectsDao.getAllProjectAllocation();
		
		for(Configuration config:configList) 
			
		{
			 for(ProjectAllocation allocation:allocationList)
			 {
				 if(config.getConfigId()==allocation.getConfigId().getConfigId())
				 {
					 Developer deObj=allocation.getDevId();
					 deList.add(deObj);
				 }
			 }
		}
		
		 System.out.println("deList : "+deList);
		 return deList;
		
		
		
		
	}
	
	
	@RequestMapping(value= {"/submitAttendance"},method=RequestMethod.GET)
	public ModelAndView submitAttendance(@ModelAttribute(name="dataObj") @Valid Attendance dataObj,BindingResult result,ModelMap map)
	{
		if(checkSession(map)) {
			return new ModelAndView("Homepage");
		}
		
		
		try
		{
			boolean saved = deoService.setAttendance(dataObj);
			map.addAttribute("msg","set Attendance Successful");
			System.out.println("done in project config");
			
			if(saved)
			{
				ModelAndView mv =new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/Attendance");
				mv.addObject("msg","Attendance Added Succesfully..");
				System.out.println("return to page and added successfully");
				return mv;
			}
			else
			{
				ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/Configurat");
				mv.addObject("errorMsg","Config Not Added Succesfully..");
				System.out.println("return to page and not added successfully");
				return mv;
			}
		}
		catch(Exception e)
		{
			System.out.println("I m catch");
			//e.printStackTrace();
			ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/Configurat");
			mv.addObject("errorMsg","Project already configured..");
			return mv;
		}
	}
	
	
	
	
}
