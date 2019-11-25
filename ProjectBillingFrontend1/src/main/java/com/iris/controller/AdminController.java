package com.iris.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.iris.dao.DeveloperDao;
import com.iris.dao.ProjectsDao;
import com.iris.models.Attendance;
import com.iris.models.Configuration;
import com.iris.models.Developer;
import com.iris.models.ProjectAllocation;
import com.iris.models.Projects;
import com.iris.models.Roles;
import com.iris.services.AdminService;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProjectsDao projectsDao;
	
	
	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value="/Configurat",method=RequestMethod.GET)
	public String Configurat(ModelMap map)
	{
		List<Configuration> con = adminService.getAllConfig();
		map.addAttribute("configList",con);
		List<Projects> proList =adminService.getAllProject();
		
		Configuration  proObj = new Configuration();
		Roles roleObj =new Roles();
		List<Roles> roleList = adminService.getAllRole();
		
		map.addAttribute("rObj", roleObj);
		map.addAttribute("pObj", proObj);
		map.addAttribute("pro",proList);
		map.addAttribute("role", roleList);
		
		return "Configurat";
		
	}
	@RequestMapping(value= {"/Allocation"},method=RequestMethod.GET)
	public String Allocation(ModelMap map) {
		List<Projects> proList =adminService.getAllProject();
		List<Roles> roleList = adminService.getAllRole();
		List<Developer> dList = adminService.getAllDeveloper();
		
		map.addAttribute("dev", dList);
		map.addAttribute("pro",proList);
		map.addAttribute("role", roleList);
		
		return "Allocation";
	}
	
	@RequestMapping(value="/submitAllocate",method=RequestMethod.GET)
	public String validateConfigr(@RequestParam int projectId,@RequestParam int roleId,@RequestParam String loc,@RequestParam int devId,ModelMap map)
	{
		System.out.println(projectId+""+roleId+""+loc+""+devId);
		List<Projects> proList =adminService.getAllProject();
		List<Roles> roleList = adminService.getAllRole();
		List<Developer> dList = adminService.getAllDeveloper();
		
		map.addAttribute("dev", dList);
		map.addAttribute("pro",proList);
		map.addAttribute("role", roleList);
		List<Configuration> Obj=projectsDao.validateProject(projectId,roleId,loc);
		
		
		Configuration configObj=Obj.get(0);
		Developer devObj=developerDao.getDeveloperById(devId);
		
		ProjectAllocation a=new ProjectAllocation();
		a.setDevId(devObj);
		a.setConfigId(configObj);
		
		boolean saved=projectsDao.setProjectAllocation(a);
		
		if(saved) {
			map.addAttribute("msg","Allocation done");
			return "Allocation";
			
		}
		else {
			map.addAttribute("msg","Allocation error");
		return "Allocation";
		}
		//System.out.println("saved");
				
		
		//return "Allocation";
	}
	
	@RequestMapping(value= {"/submitConfig"},method=RequestMethod.GET)
	public ModelAndView submitConfig(@ModelAttribute(name="pObj") @Valid Configuration pObj,BindingResult result,ModelMap map) 
	{
		try
		{
			boolean saved = adminService.setProjectConfig(pObj);
			map.addAttribute("msg","Project Config Successful");
			System.out.println("done in project config");
			
			if(saved) {
				ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/Configurat");
				mv.addObject("msg","Config  Added Succesfully..");
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
				ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/Configurat");
				mv.addObject("errorMsg","Project already configured..");
				return mv;
	}
		}
	
	@RequestMapping(value= {"viewDeveloper"},method=RequestMethod.GET)
	public String DevBill(ModelMap map)
	{
		List<Attendance> dList=adminService.getAllAttendance();
		map.addAttribute("devL", dList);
		return "viewDeveloper";
	}
	
	@RequestMapping(value= {"Bill"},method=RequestMethod.GET)
	public ModelAndView DevBills(@RequestParam(name="month") String month,@RequestParam(name="devId") int devId,@RequestParam(name="year") int year,ModelMap map)
	{
		try
		{
			System.out.println("month");
			ProjectAllocation configObj = adminService.getConfig(devId);
			double perHourBilling=configObj.getConfigId().getPerHourBilling();
			String name = adminService.getDeveloperByIdd(devId);
			System.out.println("i ma in bill");
			map.addAttribute("name", name);
			Attendance deo=developerDao.getBill(devId, month,year);
			System.out.println(deo.getFullDay());
			double bill = adminService.getBill(perHourBilling,deo);
			map.addAttribute("bill",bill);
			map.addAttribute("de", devId);
			map.addAttribute("mo",(month.charAt(0)+"").toUpperCase()+(month.substring(1).toLowerCase()));
			map.addAttribute("y",year);
			ModelAndView mv=new ModelAndView("ViewDetails");
			mv.addObject("msg","Developer Allocated Succesfully..");
			System.out.println("enter in the bill controller");
			return mv;
		}
		catch(Exception e)
		{
			ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/signIn");
			mv.addObject("errorMsg","Developer not  allocated ..");
			System.out.println("catch of bill");
			return mv;
		}
	}
	
	@RequestMapping(value= {"viewProject"},method=RequestMethod.GET)
	public String ProjBill(ModelMap map)
	{
		
		List<Projects> proList = adminService.getAllProject();
		map.addAttribute("pro", proList);
		return "viewProject";
	}
	
	@RequestMapping(value= {"BillProject"},method=RequestMethod.GET)
	public ModelAndView billingProject(@RequestParam(name="projectId") int id,@RequestParam(name="month") String month,@RequestParam(name="year") int year,ModelMap map) {
try
{
	System.out.println(id + month);
	double bill = 0;
	List<Configuration> projConfigList=projectsDao.getAllConfig(id);
	
	String name = adminService.getProjectName(id);
	map.addAttribute("name",name);
	
	map.addAttribute("month", (month.charAt(0)+"").toUpperCase()+(month.substring(1).toLowerCase()));
	
	int count = 0;
	List<Double> sum = new ArrayList<Double>();
	List<ProjectAllocation> obj = new ArrayList<ProjectAllocation>();
	
	Map<Integer,Double> myMap= (Map<Integer, Double>) new HashMap<Integer, Double>();
	
	for(Configuration configObj: projConfigList)
	{
		int cid = configObj.getConfigId();
		int perHourBilling = configObj.getPerHourBilling();
		ProjectAllocation proAllocate = developerDao.getProAllocation(cid);
		int devId = proAllocate.getDevId().getDevId();
		Attendance deo=developerDao.getBill(devId, month,year);
		
		double halfDay=deo.getHalfDay()*4.5;
		double fullDay=deo.getFullDay()*9;
		
		bill+=((halfDay+fullDay)*perHourBilling);
		double x = (halfDay*perHourBilling+fullDay*perHourBilling);
		
		 myMap.put(devId,x);
		
		sum.add(x);
		
		System.out.println("Sum X :" +(halfDay*perHourBilling+fullDay*perHourBilling));
		
		count++;
		obj.add(proAllocate);
		System.out.println(obj);
		System.out.println(sum);
		System.out.println(bill);
		System.out.println(count);
		
		
	}
	map.addAttribute("bills", sum);
	map.addAttribute("bill", bill);
	map.addAttribute("count", count);
	map.addAttribute("devl", obj);
	
	map.addAttribute("myMap", myMap);
	ModelAndView mv=new ModelAndView("ProjectBilling");
	return mv;
	
}
catch(Exception e) {
	ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBillingFrontend1/signIn");
	mv.addObject("errorMsg","Project not allocated .. ");
	return mv;
}	
	
	
	}	
}
