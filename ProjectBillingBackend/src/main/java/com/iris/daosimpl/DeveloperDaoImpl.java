package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.DeveloperDao;
import com.iris.models.Attendance;
import com.iris.models.Developer;


@Component
@Repository(value="developerDao")
@Transactional
public class DeveloperDaoImpl implements DeveloperDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Developer> getAllDeveloper()
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Developer");
			List<Developer> developerList=q.list();
			return developerList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List <Developer> developerAllocation(int devId)
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.models.Developer where devId=:devId");
			 q.setParameter("projectId",devId);
			 
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}
	
	public Developer getDeveloperById(int id)
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			Developer da=session.get(Developer.class,id);
			 return da;
			 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean setAttendance(Attendance obj)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Attendance getBill(Integer attendId,String month,int year)
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.models.Attendance where devId.devId=:i and month=:m and year=:y");
			q.setParameter("i",attendId);
			q.setParameter("m",month);
			q.setParameter("y",year);
			
			List<Attendance> deList=q.list();
			if(deList.size()!=0)
			{
				System.out.println("obj");
				return deList.get(0);
			}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
