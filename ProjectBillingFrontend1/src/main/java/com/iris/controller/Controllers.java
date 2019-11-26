package com.iris.controller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iris.dao.UserDao;
import com.iris.models.Users;






@Controller
public class Controllers {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sayHello(){
		
		
		
		return "Homepage";
}
	@RequestMapping(value="/getSignInForm",method=RequestMethod.GET)
	public String getSignInForm(){
		return "SignInForm";
	}
	
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String validateUser(@RequestParam int userId,@RequestParam String password){
		Users uObj=userDao.validateUser(userId,password);
		
		
		if(uObj!=null){
			session.setAttribute("uObj", uObj);
			if(uObj.getRole().equals("Data entry Operator"))
			{
			return "Deo";
			}
			else
			{
				return "Admin";
			
			}
		}
		else
		{
			return "SignInForm";
		}
		}
	
	@RequestMapping(value= {"logout"}, method=RequestMethod.GET)
	public String logout() {
		session.removeAttribute("uObj");
		session.invalidate();
		return "Homepage";
	}
	
}
	